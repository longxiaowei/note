package com.longxw.graphql;

import com.longxw.graphql.model.GraphqlModel;
import com.longxw.graphql.provider.DataFetcherService;
import com.longxw.graphql.provider.GraphqlDataFetchers;
import com.longxw.library.uitl.FileUtil;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * @author longxw
 * @since 2020/4/10
 */
@Slf4j
public class GraphqlInvocation implements InitializingBean {

    private GraphQL graphQL;

    private final GraphqlDataFetchers graphQLDataFetchers;

    public GraphqlInvocation(GraphqlDataFetchers graphQLDataFetchers){
        this.graphQLDataFetchers = graphQLDataFetchers;
    }

    public Object invoke(GraphqlModel graphqlModel){
        ExecutionInput.Builder builder = graphqlModel.buildExecutionInput();
        ExecutionInput executionInput = builder.build();
        ExecutionResult executionResult = this.graphQL.execute(executionInput);
        if(executionResult.getErrors() == null || executionResult.getErrors().isEmpty()){
            return executionResult.getData();
        }
        List<GraphQLError> errors = executionResult.getErrors();
        throw new RuntimeException(errors.toString());
    }

    @Override
    public void afterPropertiesSet(){
        TypeDefinitionRegistry registry = new TypeDefinitionRegistry();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        SchemaParser schemaParser = new SchemaParser();
        for (DataFetcherService service : graphQLDataFetchers.getDataFetcherServiceList()) {
            registry.merge(schemaParser.parse(parse(service.getClass().getSimpleName())));
        }
        final RuntimeWiring runtimeWiring = this.buildWiring();
        final GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();

    }

    private RuntimeWiring buildWiring() {
        RuntimeWiring.Builder builder = RuntimeWiring.newRuntimeWiring();
        for (DataFetcherWrapper dataFetcherWrapper : graphQLDataFetchers.getDataFetcherWrapperList()) {
            if(DataFetcherWrapper.TypeEnum.QUERY == dataFetcherWrapper.getType() ){
                builder.type(newTypeWiring("Query").dataFetcher(dataFetcherWrapper.getName(), dataFetcherWrapper.getDataFetcher()));
            }else if(DataFetcherWrapper.TypeEnum.MUTATION == dataFetcherWrapper.getType()){
                builder.type(newTypeWiring("Mutation").dataFetcher(dataFetcherWrapper.getName(), dataFetcherWrapper.getDataFetcher()));
            }
        }
        return builder.build();
    }

    private String parse(String serviceName){
        String path = "graphql/" + serviceName + ".graphql";
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)){
            if(inputStream == null){
                throw new RuntimeException("无法读取文件，或文件不存在： " + path);
            }
            return FileUtil.readBytesAsString(inputStream);
        }catch (IOException e){
            log.error("读取graphql文件失败： serviceName： {}, path: {}", serviceName, path);
            throw new RuntimeException("读取失败", e);
        }
    }
}
