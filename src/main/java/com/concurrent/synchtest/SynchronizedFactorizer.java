package com.concurrent.synchtest;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: javademo
 * @description: 能正确缓存最新结果，但并发非常糟糕
 * @author: chenp
 * @create: 2018-10-29 20:03
 **/
public class SynchronizedFactorizer implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 并发非常糟糕
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}