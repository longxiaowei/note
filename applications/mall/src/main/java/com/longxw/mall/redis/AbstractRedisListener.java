package com.longxw.mall.redis;

import org.springframework.data.redis.connection.MessageListener;

/**
 * @author longxw
 * @since 2020/5/13
 */
public abstract class AbstractRedisListener implements MessageListener {

    /**
     * 订阅的主题
     * @return String
     */
    public abstract String getPatternTopic();
}
