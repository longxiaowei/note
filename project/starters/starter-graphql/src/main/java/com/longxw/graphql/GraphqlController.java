package com.longxw.graphql;

import com.longxw.graphql.model.GraphqlModel;
import graphql.Internal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


/**
 * @author longxw
 * @since 2020/4/7
 */
@RestController
@Internal
public class GraphqlController {


    private final GraphqlInvocation graphqlInvocation;

    public GraphqlController(GraphqlInvocation graphqlInvocation){
        this.graphqlInvocation = graphqlInvocation;
    }

    @PostMapping("/graphql")
    public Object query(@RequestBody GraphqlModel graphqlModel, WebRequest webRequest){
        return graphqlInvocation.invoke(graphqlModel);
    }

}
