package com.dupenghao.mybatis.service;

import com.dupenghao.mybatis.pojo.Book;
import com.github.pagehelper.PageInfo;

/**
 * Created by 杜鹏豪 on 2022/8/18.
 */
public interface BookService {
    int save(Book book);

    PageInfo<Book> getList();
}
