package com.longxw.graphql.model;

import graphql.ExecutionInput;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author longxw
 * @since 2020/4/10
 */

@Setter
@Getter
public class GraphqlModel {

    private String query;
    private String operationName;
    private Map<String, Object> variables;

    public ExecutionInput.Builder buildExecutionInput(){
        return ExecutionInput.newExecutionInput()
                .query(this.query)
                .operationName(this.operationName)
                .variables(this.variables);
    }

}
