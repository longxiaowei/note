package com.longxw.mall.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

/**
 * @author longxw
 * @since 2020/5/13
 */
@Component
public class AuthRedisListener extends AbstractRedisListener {

    public static final String topic = "auth";

    @Override
    public String getPatternTopic() {
        return topic;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(topic+"收到消息："+ message.toString());
    }
}
