package com.longxw.graphql;

import com.longxw.graphql.model.GraphqlModel;
import com.longxw.graphql.model.GraphqlServletContext;
import graphql.Internal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    public Object query(@RequestBody GraphqlModel graphqlModel, HttpServletRequest request, HttpServletResponse response){
        GraphqlServletContext graphqlServletContext = new GraphqlServletContext(request, response);
        return graphqlInvocation.invoke(graphqlModel, graphqlServletContext);
    }

}
