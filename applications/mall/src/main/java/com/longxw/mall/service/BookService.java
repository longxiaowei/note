package com.longxw.mall.service;

import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.provider.DataFetcherService;
import com.longxw.mall.model.Book;
import org.springframework.stereotype.Service;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Service
public class BookService implements DataFetcherService {

    @GraphqlQuery
    public Book bookById(String id, String name, Integer pageCount){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPageCount(pageCount);
        return book;
    }
}
