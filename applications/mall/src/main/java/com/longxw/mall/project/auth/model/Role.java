package com.longxw.mall.project.auth.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author longxw
 * @since 2020/4/23
 */
@Data
@TableName("mc_auth_role")
public class Role {

    private String id;
    private String code;

}
