package com.longxw.mall.redis;

import com.longxw.mall.util.SpringBeanUtil;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

/**
 * @author longxw
 * @since 2020/4/14
 */
public class RedisUtil {

    private static StringRedisTemplate stringRedisTemplate = SpringBeanUtil.getBean(StringRedisTemplate.class);

    private RedisUtil(){
    }

    public static String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public static void set(String key, String value, Duration duration){
        stringRedisTemplate.opsForValue().set(key, value, duration);
    }

    public static boolean del(String key){
        return stringRedisTemplate.delete(key);
    }
}
