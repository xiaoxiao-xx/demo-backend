package com.rainyhon.common.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	private static volatile JedisPool pool = null;

	public JedisPoolUtil(String redisServer, int redisPort) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(500);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10);
		// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
		config.setTestOnBorrow(true);
		// new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
		pool = new JedisPool(config, redisServer, redisPort, 10000);
	}

	public JedisPool getJedisPool() {
		return pool;
	}

	/**
	 * Return the jedis connection to the pool
	 */
	public void close(Jedis jedis) {
		jedis.close();
	}

	private Jedis getJedis() {
		return pool.getResource();
	}

	public Set<String> keys(String pattern) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.keys(pattern);
		}
	}

	public boolean exists(String key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.exists(key);
		}
	}

	public boolean exists(byte[] key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.exists(key);
		}
	}

	public String get(String key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.get(key);
		}
	}

	public void setex(String key, int time, String value) {
		try (Jedis jedis = this.getJedis()) {
			jedis.setex(key, time, value);
		}
	}

	public void expire(String key, int time) {
		try (Jedis jedis = this.getJedis()) {
			jedis.expire(key, time);
		}
	}

	public void setBinary(Serializable key, int seconds, Serializable value) {
		try (Jedis jedis = this.getJedis()) {
			jedis.setex(Object2Byte.getBytesFromObject(key), seconds, Object2Byte.getBytesFromObject(value));
		}
	}

	public boolean existsBinary(Serializable key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.exists(Object2Byte.getBytesFromObject(key));
		}
	}

	public void expireBinary(Serializable key, int seconds) {
		try (Jedis jedis = this.getJedis()) {
			jedis.expire(Object2Byte.getBytesFromObject(key), seconds);
		}
	}

	public <T> T getBinary(Serializable key) {
		try (Jedis jedis = this.getJedis()) {
			return Object2Byte.getObjectFromBytes(jedis.get(Object2Byte.getBytesFromObject(key)));
		}
	}

	public void hmset(String key, Map<String, String> value) {
		try (Jedis jedis = this.getJedis()) {
			jedis.hmset(key, value);
		}
	}

	public List<String> hmget(String key, String... values) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.hmget(key, values);
		}
	}

	public void del(String key) {
		try (Jedis jedis = this.getJedis()) {
			jedis.del(key);
		}
	}

	public void del(byte[] key) {
		try (Jedis jedis = this.getJedis()) {
			jedis.del(key);
		}
	}

	public Long sadd(String key, String... members) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.sadd(key, members);
		}
	}

	public void srem(String key, String... members) {
		try (Jedis jedis = this.getJedis()) {
			jedis.srem(key, members);
		}
	}

	public Set<String> smemebers(String key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.smembers(key);
		}
	}

	public Long scard(String key) {
		try (Jedis jedis = this.getJedis()) {
			return jedis.scard(key);
		}
	}

}
