package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.annotation.WebFilter;

/**
 * LoginFilter
 */
// @WebFilter(urlPatterns = "/v1/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("doFilter loginFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // String userName = req.getParameter("username");
        chain.doFilter(req, resp);
        // if ("yestin".equals(userName)) {
        //     chain.doFilter(req, resp);
        // } else {
        //     return ;
        // }
    }

    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}