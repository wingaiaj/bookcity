package com.project.control;

import com.project.Dao.impl.fruitDaoImp;
import com.project.Dao.pojo.Fruit;
import com.project.SpringMVC.utlis.Connections;
import com.project.SpringMVC.utlis.StringUtils;
import com.project.SpringMVC.view.ViewBaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

/**
 * @ClassName FruitControl
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/15 21:01
 * @Version 1.0
 */
public class FruitControl extends ViewBaseServlet {
    fruitDaoImp fruitDaoImp = new fruitDaoImp();

    private ServletContext servletContext ;

    public void setServletContext(ServletContext servletContext) throws ServletException {
        this.servletContext = servletContext;
        super.init(servletContext);
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //起始页为1
        int pageNo = 1;
        //获取session
        HttpSession session = req.getSession();
        String op = req.getParameter("op");
        String keyword;
        if (StringUtils.isNotEmpty(op) && "oper".equals(op)) {
            keyword = req.getParameter("keyword");
            if ("".equals(keyword) || null == keyword) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            String pageNoStr = req.getParameter("pageNo");
            if (StringUtils.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");

            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }
        List<Fruit> fruitList = fruitDaoImp.QueryList( pageNo, keyword);
        Long count = fruitDaoImp.count( keyword);

        session.setAttribute("fruitList", fruitList);
        session.setAttribute("count", (count + 6 - 1) / 6);
        session.setAttribute("pageNo", pageNo);
        processTemplate("index", req, resp);

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        String fname = req.getParameter("fname");
        String fpriceStr = req.getParameter("fprice");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");
        fruitDaoImp.update( new Fruit(Integer.parseInt(fidStr), fname, Integer.parseInt(fpriceStr), Integer.parseInt(fcountStr), remark));

        resp.sendRedirect("fruit.do");
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String fpriceStr = req.getParameter("fprice");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");
        boolean insert = fruitDaoImp.insert( new Fruit(fname, Integer.parseInt(fpriceStr), Integer.parseInt(fcountStr), remark));
        resp.sendRedirect("fruit.do");
    }

    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");
        fruitDaoImp fruitDaoImp = new fruitDaoImp();
        Connection connection = Connections.getConnection();
        fruitDaoImp.del( Integer.parseInt(fid));

        resp.sendRedirect("fruit.do");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr = req.getParameter("fid");
        int fid = Integer.parseInt(fidstr);
        Fruit fruit = fruitDaoImp.Query( fid);
        req.setAttribute("fruit", fruit);
        processTemplate("edit", req, resp);
    }
}
