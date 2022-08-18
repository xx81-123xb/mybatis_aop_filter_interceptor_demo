package com.dupenghao.mybatis.controller;

import com.dupenghao.mybatis.commans.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@RestController
@RequestMapping("/api/Param")
@Api(tags = {"参数接口"})
public class ParamController {


    @GetMapping("/callBack/{param}")
    @ApiOperation("回响参数")
    public Result callBack(@PathVariable String param){
        return Result.getSuccess(param);
    }

    @GetMapping("/shutdown")
    public Result shutdown(){
        System.exit(0);
        return null;
    }

}
