package com.dupenghao.mybatis.mapper;

import com.dupenghao.mybatis.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Mapper
public interface BookMapper {

    @Insert("insert into tbl_book values (#{id},#{author},#{type},#{price},#{name})")
    int save(Book book);

    @Select("select * from tbl_book ")
    List<Book> getList();

}
