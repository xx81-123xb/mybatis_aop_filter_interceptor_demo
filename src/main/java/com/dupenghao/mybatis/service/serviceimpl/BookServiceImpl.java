package com.dupenghao.mybatis.service.serviceimpl;

import com.dupenghao.mybatis.mapper.BookMapper;
import com.dupenghao.mybatis.pojo.Book;
import com.dupenghao.mybatis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 杜鹏豪 on 2022/8/18.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public int save(Book book) {
        return mapper.save(book);
    }
}
