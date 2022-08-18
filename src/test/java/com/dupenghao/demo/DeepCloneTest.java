package com.dupenghao.demo;

import com.dupenghao.mybatis.pojo.Book;
import com.dupenghao.util.CloneUtil;
import org.junit.Test;

/**
 * Created by 杜鹏豪 on 2022/8/18.
 */

public class DeepCloneTest {

    @Test
    public void testTwoPOJO() throws CloneNotSupportedException {
        Book book = new Book("偷香猎人", "白眉散人", "H", "100.65",null);
        Book book2 = (Book) book.clone();
//        Book book2 = book;
        System.out.println(book==book2);
    }

    @Test
    public void testDeepClone(){
        Book book = new Book("偷香猎人", "白眉散人", "H", "100.65",null);
//        Book book2 = new Book("偷香猎人", "白眉散人", "H", "100.65",null);
//        book.setMybook(book);
//        book2.setMybook(book2);
        Book cloneBook = (Book) CloneUtil.deepClone(book);
//        System.out.println(book);
//        System.out.println(cloneBook);
        book.show();
        cloneBook.show();
        book.setName("偷香猎人2");
        System.out.println(book.equals(cloneBook));
        System.out.println(book == cloneBook);
        System.out.println("=======================");
        book.show();
        cloneBook.show();
    }

}
