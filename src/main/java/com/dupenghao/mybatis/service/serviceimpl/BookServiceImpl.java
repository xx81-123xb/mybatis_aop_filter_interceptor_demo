package com.dupenghao.mybatis.service.serviceimpl;

import com.dupenghao.mybatis.mapper.BookMapper;
import com.dupenghao.mybatis.pojo.Book;
import com.dupenghao.mybatis.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杜鹏豪 on 2022/8/18.
 */
@SuppressWarnings("all")
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public int save(Book book) {
        int result = mapper.save(book);
        return result;
    }

    @Override
    public PageInfo<Book> getList() {
        PageHelper.startPage(2, 2);
        List<Book> list = mapper.getList();
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        pageInfo.getList().forEach(findbook -> {
            findbook.show();
        });
        return pageInfo;
    }
}
