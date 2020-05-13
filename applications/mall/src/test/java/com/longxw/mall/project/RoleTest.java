package com.longxw.mall.project;

import com.longxw.mall.project.mapper.RoleMapper;
import com.longxw.mall.project.auth.model.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testSelect(){
        final Role role = roleMapper.selectById("1234");
        Assert.assertNull(role);
    }

}
