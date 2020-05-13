package com.longxw.mall.project.auth.controller;

import com.longxw.mall.project.auth.model.Role;
import com.longxw.mall.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longxw
 * @since 2020/5/13
 */
@RestController
public class RoleController {


    @Autowired
    RedisService redisService;

    @RequestMapping("/test/redis")
    public void test(){
        Role role = new Role();
        role.setCode("123");
        long a = 123L;
        redisService.set("456", a);
        long result = redisService.get("456");
        redisService.set("123", role);
        Role i = redisService.get("123");
        System.out.println(i);


        System.out.println(result);
        redisService.getRedisTemplate().convertAndSend("test", "测试一下");
    }
}
