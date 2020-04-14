package com.longxw.mall.service;

import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.provider.DataFetcherService;
import com.longxw.mall.lock.RedisLock;
import com.longxw.mall.model.Book;
import com.longxw.mall.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Service
public class BookService implements DataFetcherService {

    @Autowired
    RedisLock redisLock;

    @GraphqlQuery
    public Book bookById(String id, String name, Integer pageCount){
        try {
            this.redisLock.setIfAbsent("cs", "cv");
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setPageCount(pageCount);
            return book;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            RedisUtil.del("cs");
        }
    }
}
