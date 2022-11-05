package com.zx.Servlet;

import com.zx.Fruit.impl.fruitDaoImp;
import com.zx.myssm.utils.Connections;
import com.zx.myssm.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @ClassName DelServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/14 20:08
 * @Version 1.0
 */
@WebServlet("/del")
public class DelServlet extends HttpServlet {
    Connection connection = Connections.getConnection();
    fruitDaoImp fruitDaoImp = new fruitDaoImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        int fid = 0;
        if (StringUtils.isNotEmpty(fidStr)) {
            fid = Integer.parseInt(fidStr);
        }
        boolean del = fruitDaoImp.del(connection, fid);

        resp.sendRedirect("index");

    }
}
