package com.dupenghao.mybatis.config;

import com.dupenghao.mybatis.interceptor.ParamInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer,ServletContextInitializer{

    @Autowired
    private ParamInterceptor paramInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paramInterceptor).addPathPatterns("/**");
    }

    @Bean
    public Docket customImplation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo())
                .groupName("2.X版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dupenghao.mybatis.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo myApiInfo(){
        ApiInfo info = new ApiInfoBuilder()
                .description("# swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.xx.com/")
//                .contact("xx@qq.com")
                .version("1.0.0")
                .build();
        return info;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("=================dupenghao==================");
    }
}
