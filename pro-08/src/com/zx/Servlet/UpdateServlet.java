package com.zx.Servlet;

import com.zx.Fruit.impl.fruitDaoImp;
import com.zx.Fruit.pojo.Fruit;
import com.zx.myssm.SpringMVC.ViewBaseServlet;
import com.zx.myssm.utils.Connections;
import com.zx.myssm.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @ClassName UpdateServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/14 18:52
 * @Version 1.0
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    fruitDaoImp fruitDao = new fruitDaoImp();
    Connection connection = Connections.getConnection();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String fidStr = req.getParameter("fid");
        String fname = req.getParameter("fname");
        String fpriceStr = req.getParameter("fprice");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");
        int fid = 0;
        int fcount = 0;
        int fprice = 0;
        if (StringUtils.isNotEmpty(fidStr)) {
            fid = Integer.parseInt(fidStr);
        }
        if (StringUtils.isNotEmpty(fpriceStr)) {
            fprice = Integer.parseInt(fpriceStr);
        }
        if (StringUtils.isNotEmpty(fcountStr)) {
            fcount = Integer.parseInt(fcountStr);
        }

        boolean update = fruitDao.update(connection, new Fruit(fid, fname, fprice, fcount, remark));

       resp.sendRedirect("index");
    }
}
