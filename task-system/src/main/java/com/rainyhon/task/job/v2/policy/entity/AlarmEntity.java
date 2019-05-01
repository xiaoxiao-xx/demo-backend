package com.rainyhon.task.job.v2.policy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 告警内容的缓存及过期时间
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
@Data
@AllArgsConstructor
public class AlarmEntity implements Comparable<AlarmEntity>{

    private String key;

    private Date firstTime;

    private long expireTime;

    @Override
    public int compareTo(AlarmEntity o) {
        long r = this.expireTime - o.expireTime;
        if (r > 0) {
            return 1;
        }
        if (r < 0) {
            return -1;
        }
        return 0;
    }
}
