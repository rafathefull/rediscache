package com.example.demo.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RequestInterceptor implements HandlerInterceptor {
    private final Logger customLogger = LoggerFactory.getLogger(getClass());

    long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        customLogger.info(  "\n===========================================\n" +
                " requestURL: " + request.getRequestURL() + "\n" +
                " remoteHost: " + request.getRemoteHost() + "\n" +
                " servletPath:" + request.getServletPath() + "\n" +
                " method:     " + request.getMethod() + "\n" +
                " status:     " + response.getStatus() + "\n" +
                " afterCompletion Execution Time: " + executionTime + "ms\n" +
                "===========================================\n"
        );
    }
}