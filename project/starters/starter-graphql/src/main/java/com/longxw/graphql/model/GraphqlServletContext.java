package com.longxw.graphql.model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author longxw
 * @since 2020/5/13
 */
@Data
public class GraphqlServletContext {

    public GraphqlServletContext(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;
}
