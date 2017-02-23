package com.imp.filter;

import com.baidu.ueditor.ActionEnter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by (IMP)郑和明
 * Date is 2016/12/26
 *
 * UEditor controller.jsp 拦截器
 *
 * 初始化 config,json
 *
 */
@WebFilter(filterName = "UEditorFilter",urlPatterns = "/ueditor/jsp/controller.jsp")
public class UEditorFilter implements Filter {
    private FilterConfig config;

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        String rootPath= config.getServletContext().getRealPath("/");
        String res=new ActionEnter(request, rootPath).exec();
        response.getWriter().write(res);

    }
    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
