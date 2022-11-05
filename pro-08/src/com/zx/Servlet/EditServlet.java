package com.zx.Servlet;

import com.zx.Fruit.impl.fruitDaoImp;
import com.zx.Fruit.pojo.Fruit;
import com.zx.myssm.SpringMVC.ViewBaseServlet;
import com.zx.myssm.utils.Connections;
import com.zx.myssm.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * @ClassName EditServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/14 9:48
 * @Version 1.0
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    fruitDaoImp fruitDaoImp = new fruitDaoImp();
    Connection connection = Connections.getConnection();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fidStr = req.getParameter("fid");
        int fid = 0;
        if (StringUtils.isNotEmpty(fidStr)) {
             fid = Integer.parseInt(fidStr);
        }
        Fruit fruit = fruitDaoImp.Query(connection, fid);

        req.setAttribute("fruit",fruit);

        processTemplate("edit",req,resp);


    }
}
