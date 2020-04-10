package com.longxw.graphql.provider;

import com.longxw.graphql.DataFetcherWrapper;
import com.longxw.graphql.annotation.GraphqlMutation;
import com.longxw.graphql.annotation.GraphqlQuery;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longxw
 * @since 2020/4/1
 */
@Slf4j
public class GraphqlDataFetchers implements InitializingBean {

    @Getter
    private List<DataFetcherWrapper> dataFetcherWrapperList;

    @Getter
    private final List<DataFetcherService> dataFetcherServiceList;

    public GraphqlDataFetchers(List<DataFetcherService> dataFetcherServiceList){
        if (dataFetcherServiceList.isEmpty()) {
            throw new RuntimeException("找不到 DataFetcherService");
        }
        this.dataFetcherServiceList = dataFetcherServiceList;
    }

    @Override
    public void afterPropertiesSet() {
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        dataFetcherWrapperList = new ArrayList<>(dataFetcherServiceList.size() * 5);
        dataFetcherServiceList.forEach(service -> {
            Method[] methods = service.getClass().getMethods();
            String serviceName = service.getClass().getSimpleName();
            Arrays.stream(methods).forEach(method -> {
                if(method.getAnnotation(GraphqlQuery.class) !=null){
                    dataFetcherWrapperList.add(new DataFetcherWrapper(DataFetcherWrapper.TypeEnum.QUERY, method, serviceName + "_" + method.getName(), service, parameterNameDiscoverer.getParameterNames(method)));
                }else if (method.getAnnotation(GraphqlMutation.class) != null){
                    dataFetcherWrapperList.add(new DataFetcherWrapper(DataFetcherWrapper.TypeEnum.QUERY, method, serviceName + "_" + method.getName(), service, parameterNameDiscoverer.getParameterNames(method)));
                }
            });
        });
    }

}
