package com.dupenghao.mybatis.commans;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Data
public class Result implements Serializable {

    private String info;
    private int rlt;
    private Object data;

    public static Result getSuccess(Object data){
        Result result = new Result();
        result.info=INFO.SUCCESS.value;
        result.data=data;
        result.rlt=0;
        return result;
    }

    public static Result getFail(Object data){
        Result result = new Result();
        result.info=INFO.FAILURE.value;
        result.data=data;
        result.rlt=1;
        return result;
    }

    private enum INFO{
        SUCCESS("success"),FAILURE("failure");

        private String value;

        INFO(String value){
            this.value=value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
