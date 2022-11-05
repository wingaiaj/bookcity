package com.zx.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ServletDemo01
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/13 20:13
 * @Version 1.0
 */
@WebServlet("/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("uname", "device");

        resp.sendRedirect("demo02");
    }
}
