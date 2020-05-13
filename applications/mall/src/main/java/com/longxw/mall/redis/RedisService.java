package com.longxw.mall.redis;

import com.longxw.library.common.Assert;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author longxw
 * @since 2020/5/13
 */
@Service
public class RedisService {

    private final long TIMEOUT = 60 * 60 * 24;

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> template){
        this.redisTemplate = template;
    }

    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Serializable value){
        redisTemplate.opsForValue().set(key, value, TIMEOUT, TimeUnit.SECONDS);
    }

    public void set(String key, Serializable value, long timeout){
        Assert.assertTrue(timeout > 0, "有效期[timeout]必须大于 0");
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }
}
