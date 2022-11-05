package com.lazyboyprod.servlets;

import javax.servlet.*;
import java.io.IOException;

public class HelloSimpleServlet implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("REQUEST: " + servletRequest.getLocalName());
        servletResponse.getWriter().println("This is hello simple servlet");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
