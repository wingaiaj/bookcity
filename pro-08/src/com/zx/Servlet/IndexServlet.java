package com.zx.Servlet;

import com.zx.Fruit.impl.fruitDao;
import com.zx.Fruit.impl.fruitDaoImp;
import com.zx.Fruit.pojo.Fruit;
import com.zx.myssm.SpringMVC.ViewBaseServlet;
import com.zx.myssm.utils.Connections;
import com.zx.myssm.utils.StringUtils;
import javassist.compiler.ast.Keyword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @ClassName IndexServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/12 21:14
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
        //获取连接
        Connection connection = Connections.getConnection();
        fruitDaoImp fruitDao = new fruitDaoImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置字符集
        request.setCharacterEncoding("utf-8");
        //默认页面为1
        int pageNo = 1;
        //获取session
        HttpSession session = request.getSession();

        String op = request.getParameter("op");

        String keyword = null;
        //判断是否为表单提交
        if(StringUtils.isNotEmpty(op)&&"oper".equals(op)){
                //为表单提交
        //获取关键字
         keyword = request.getParameter("keyword");
            if(StringUtils.isEmpty(keyword)){
                keyword = "";
            }
            //保存在session 作用域中
            session.setAttribute("keyword",keyword);

        }else {
            //获取参数
            String pageNoStr = request.getParameter("pageNo");

            //不为空
            if (StringUtils.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            //session 作用域中获取 keyword
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj==null){
                keyword = "";
            }
            else {
            keyword = (String)keywordObj;
            }
        }
            //根据pageno 查询库存
            List<Fruit> fruitList = fruitDao.QueryList(connection, pageNo, keyword);

            Long count = fruitDao.count(connection, keyword);

            //保存在作用域
            session.setAttribute("count", (count+6-1)/6);
            session.setAttribute("pageNo", pageNo);
            session.setAttribute("fruitList", fruitList);

        //处理模板
        super.processTemplate("index", request, response);
    }
}
