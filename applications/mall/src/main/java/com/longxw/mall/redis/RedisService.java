package com.longxw.mall.redis;

import com.longxw.library.common.Assert;
import lombok.Getter;
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

    @Getter
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> template){
        this.redisTemplate = template;
    }

    public <T> T get(String key){
        ObjectWrapper o = (ObjectWrapper)redisTemplate.opsForValue().get(key);
        return  (T)o.getObject();
    }

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, new ObjectWrapper(value));
    }

    public void set(String key, Serializable value, long timeout){
        Assert.assertTrue(timeout > 0, "有效期[timeout]必须大于 0");
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }
}
