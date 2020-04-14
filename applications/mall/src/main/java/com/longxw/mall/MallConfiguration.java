package com.longxw.mall;

import com.longxw.mall.lock.RedisLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author longxw
 * @since 2020/4/14
 */
@Configuration
public class MallConfiguration {

    @Bean
    public RedisLock redisLock(StringRedisTemplate redisTemplate){
        return new RedisLock(redisTemplate);
    }
}
