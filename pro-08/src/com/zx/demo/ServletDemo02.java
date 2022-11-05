package com.zx.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletDemo02
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/13 20:13
 * @Version 1.0
 */
@WebServlet("/demo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        Object uname = application.getAttribute("uname");
        System.out.println(uname);

    }
}
