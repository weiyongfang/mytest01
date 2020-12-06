package com.itheima.cont;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//统计访问次数
@WebServlet("/count")
public class countServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        //生命周期中只执行一次
        //获取servletContext对象
        ServletContext servletContext = getServletContext();
        //给计数器赋值并存到对象中
        int count=0;
        servletContext.setAttribute("count",count);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //访问一次，响应一次,计数器加一
               //获取计数器
        Integer count = (Integer) getServletContext().getAttribute("count");
        count++;
        //把统计的次数存在在公供容器中
        getServletContext().setAttribute("count",count);
    }
}
