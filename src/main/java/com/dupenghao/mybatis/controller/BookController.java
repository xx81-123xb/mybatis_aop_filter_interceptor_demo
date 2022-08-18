package com.dupenghao.mybatis.controller;

import com.dupenghao.mybatis.commans.Result;
import com.dupenghao.mybatis.pojo.Book;
import com.dupenghao.mybatis.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@RestController
@RequestMapping("/api/Book")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("save")
    public Result save(@RequestBody Book book){
        log.info("book:{}",book);
        bookService.save(book);
        return Result.getSuccess(book);
    }

}
