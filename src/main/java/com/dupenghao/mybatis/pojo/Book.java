package com.dupenghao.mybatis.pojo;

import com.dupenghao.mybatis.commans.AbstractPOJO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractPOJO implements Serializable,Cloneable{

    private static final long serialVersionUID=123456789L;

    private String name;
    private String author;
    private String type;
    private String price;
    private Book mybook;

    public void show(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.toString()).append("\r\n");
        sb.append("hashcode: ").append(this.hashCode()).append("\r\n");

        System.out.println(sb.toString());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
