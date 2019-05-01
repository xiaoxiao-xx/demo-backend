package com.rainyhon.task.job.v2.policy.base;

import com.rainyhon.task.job.v2.policy.entity.AlarmEntity;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 告警记录唯一记录本地缓存
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
public class LocalExpiredCache {

    private static ScheduledExecutorService swapExpiredPool = new ScheduledThreadPoolExecutor(10);

    private ReentrantLock lock = new ReentrantLock();

    private ConcurrentHashMap<String, AlarmEntity> cache = new ConcurrentHashMap<>(1024);

    /**
     * 让过期时间最小的数据排在队列前，在清除过期数据时
     * ，只需查看缓存最近的过期数据，而不用扫描全部缓存
     */
    private PriorityQueue<AlarmEntity> expireQueue = new PriorityQueue<>(1024);

    public LocalExpiredCache() {
        //使用默认的线程池，每1秒清除一次过期数据
        //线程池和调用频率 最好是交给调用者去设置。
        swapExpiredPool.scheduleWithFixedDelay(new SwapExpiredNodeWork(), 0, 1, TimeUnit.SECONDS);
    }

    public void set(String key, Date currentTime, long timeout) {
        long expireTime = currentTime.getTime() + timeout;
        AlarmEntity last = cache.get(key);
        AlarmEntity newNode;
        if (last == null) {
            newNode = new AlarmEntity(key, currentTime, expireTime);
        } else {
            newNode = last;
            last.setExpireTime(expireTime);
        }
        lock.lock();
        try {
            AlarmEntity old = cache.put(key, newNode);
            expireQueue.add(newNode);
            //如果该key存在数据，还要从过期时间队列删除
            if (old != null) {
                expireQueue.remove(old);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 拿到的数据可能是已经过期的数据，可以再次判断一下
     * if（n.expireTime<System.currentTimeMillis()）{
     * return null;
     * }
     * 也可以直接返回整个节点Node ，交给调用者去取舍
     * <p>
     * <p>
     * 无法判断不存在该key,还是该key存的是一个null值，如果需要区分这两种情况
     * 可以定义一个全局标识，标识key不存在
     * public static final NOT_EXIST = new Object();
     * 返回值时
     * return n==null?NOT_EXIST:n.value;
     */
    public AlarmEntity get(String key) {
        AlarmEntity n = cache.get(key);
        return n == null ? null : n;
    }

    /**
     * 删出KEY，并返回该key对应的数据
     */
    public Object remove(String key) {
        lock.lock();
        try {
            AlarmEntity n = cache.remove(key);
            if (n == null) {
                return null;
            } else {
                expireQueue.remove(n);
                return n.getKey();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 删除已经过期的数据
     */
    private class SwapExpiredNodeWork implements Runnable {

        @Override
        public void run() {

            long now = System.currentTimeMillis();
            while (true) {
                lock.lock();
                try {
                    AlarmEntity node = expireQueue.peek();
                    //没有数据了，或者数据都是没有过期的了
                    if (node == null || node.getExpireTime() > now) {
                        return;
                    }
                    System.out.println(node.getKey() + "过期，当前时间：" + System.currentTimeMillis());
                    cache.remove(node.getKey());
                    expireQueue.poll();

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LocalExpiredCache cache = new LocalExpiredCache();
        new Thread(() -> {
            while (true) {
                AlarmEntity leizhenyang = cache.get("leizhenyang");
                if (leizhenyang != null) {
                    long time = leizhenyang.getFirstTime().getTime();
                    long b = leizhenyang.getExpireTime() - time;
                    System.out.println(b);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Date date = new Date();
        cache.set("leizhenyang", date, 5 * 1000);
        Thread.sleep(4000);
        cache.set("leizhenyang", date, 10 * 1000);



    }
}
