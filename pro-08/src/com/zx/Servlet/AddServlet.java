package com.zx.Servlet;

import com.zx.Fruit.impl.fruitDao;
import com.zx.Fruit.impl.fruitDaoImp;
import com.zx.Fruit.pojo.Fruit;
import com.zx.myssm.utils.Connections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @ClassName AddServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/14 20:36
 * @Version 1.0
 */
@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
    fruitDaoImp fruitDaoImp = new fruitDaoImp();
    Connection connection = Connections.getConnection();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String fname = req.getParameter("fname");
        String fpriceStr = req.getParameter("fprice");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");
        int fprice = Integer.parseInt(fpriceStr);
        int fcount = Integer.parseInt(fcountStr);

        boolean insert = fruitDaoImp.insert(connection, new Fruit(fname, fprice, fcount, remark));

        resp.sendRedirect("index");

    }
}
