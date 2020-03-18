package com.edu.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "device_adapter",urlPatterns = "*.jsp")
public class device_adapter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse reps = (HttpServletResponse)servletResponse;
        String uri = req.getRequestURI();
        uri = uri.substring(14);
        System.out.println(uri);
        //以什么开头
        if(uri.indexOf("Filter/PC") != -1 || uri.indexOf("Filter/mobile") != -1){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            //请求头
            String userAgent = req.getHeader("user-agent");
            System.out.println(userAgent);
            String targenturi = "";
            if(userAgent.indexOf("Android") != -1 || userAgent.indexOf("Iphone") != -1){
                targenturi = "Filter/mobile/" + uri;
                System.out.println("移动端正在访问，重新调整");
                reps.sendRedirect(targenturi);
            }
            else{
                targenturi = "Filter/PC/" + uri;
                System.out.println("PC端正在访问，重新调整");
                reps.sendRedirect(targenturi);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
