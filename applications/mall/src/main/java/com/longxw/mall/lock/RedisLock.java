package com.longxw.mall.lock;

import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author longxw
 * @since 2020/4/14
 */
public class RedisLock {

    private final StringRedisTemplate redisTemplate;

    public RedisLock(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 如果key 不存在
     * @param k
     * @param value
     * @return
     */
    public Boolean setIfAbsent(String k, String value){
        return this.redisTemplate.opsForValue().setIfAbsent(k, value);
    }

}
