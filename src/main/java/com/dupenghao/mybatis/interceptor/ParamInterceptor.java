package com.dupenghao.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 杜鹏豪 on 2022/8/9.
 */
@Slf4j
@Component
//@Order
public class ParamInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            log.info("cookie name:{}",name);
        }
        //密码统一解码
        log.info("interceptor is run");
        Class<?> aClass = handler.getClass();
        log.info("handler class :{}",aClass.getName());
        if(request.getRequestURI().contains("forbidden")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            log.info("forbidden");
//            response.sendError(HttpServletResponse.SC_FORBIDDEN);
//            return false;
            Cookie cookie = new Cookie("dph", "test");
//            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            response.sendError(HttpServletResponse.SC_FORBIDDEN,"无权访问!");
//            response.getOutputStream().println("no quanxian");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Cookie cookie = new Cookie("dph", "test");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        log.info("interceptor is post");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("interceptor is completion");
    }
}
