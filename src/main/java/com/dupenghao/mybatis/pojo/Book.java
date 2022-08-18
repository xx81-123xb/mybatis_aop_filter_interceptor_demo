package com.dupenghao.mybatis.pojo;

import com.dupenghao.mybatis.commans.AbstractPOJO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractPOJO{

    private String name;
    private String author;
    private String type;
    private String price;

}
