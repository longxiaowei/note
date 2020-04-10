package com.longxw.graphql;

import com.longxw.graphql.provider.DataFetcherService;
import com.longxw.graphql.provider.GraphqlDataFetchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author longxw
 * @since 2020/4/10
 */

@Configuration
public class GraphqlConfiguration {

    @Bean
    public GraphqlDataFetchers graphQLDataFetchers(@Autowired(required = false) List<DataFetcherService> dataFetcherServices){
        return new GraphqlDataFetchers(dataFetcherServices);
    }

    @Bean
    public GraphqlInvocation graphqlInvocation(@Autowired GraphqlDataFetchers graphQLDataFetchers){
        return new GraphqlInvocation(graphQLDataFetchers);
    }
}
