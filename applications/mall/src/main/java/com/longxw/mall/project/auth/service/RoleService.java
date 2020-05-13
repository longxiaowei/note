package com.longxw.mall.project.auth.service;

import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.provider.DataFetcherService;
import com.longxw.mall.project.mapper.RoleMapper;
import com.longxw.mall.project.auth.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author longxw
 * @since 2020/5/13
 */
@Service
@AllArgsConstructor
public class RoleService implements DataFetcherService {

    private final RoleMapper roleMapper;

    @GraphqlQuery
    public Role findById(String id){
        Role role = this.roleMapper.selectById(id);
        return role;
    }
}
