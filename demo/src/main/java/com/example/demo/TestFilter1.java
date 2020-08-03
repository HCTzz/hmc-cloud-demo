package com.example.demo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author HHF
 * @Description
 * @create 2020-06-17 上午 8:12
 */
@Order(199)
@Component
public class TestFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init --- 2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter -- 2");
    }

    @Override
    public void destroy() {
        System.out.println("destroy --- 2");
    }
}
