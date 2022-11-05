package com.project.SpringMVC.dispatchServlet;

import com.project.Dao.pojo.Fruit;
import com.project.SpringMVC.utlis.StringUtils;
import com.project.SpringMVC.view.ViewBaseServlet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DispatchServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/16 16:31
 * @Version 1.0
 */
@WebServlet("*.do")
public class DispatchServlet extends HttpServlet {

    Map<String, Object> beanMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            //加载配置文件
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(resourceAsStream);
            NodeList beanList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanList.getLength(); i++) {
                //获取节点内容
                Node bean = beanList.item(i);
                //如果为文本元素节点
                if (bean.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) bean;
                    String id = beanElement.getAttribute("id");
                    String aClass = beanElement.getAttribute("class");
                    Class<?> aClazz = Class.forName(aClass);
                    Object o = aClazz.newInstance();
                    Method setServletContextMethod = aClazz.getDeclaredMethod("setServletContext", ServletContext.class);
                    setServletContextMethod.invoke(o, this.getServletContext());
                    beanMap.put(id, o);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //截取字符串
        String servletPath = req.getServletPath();
        String contextPath1 = servletPath.substring(1);
        int dotLength = contextPath1.lastIndexOf(".do");

        String servletName = contextPath1.substring(0, dotLength);

        Object o = beanMap.get(servletName);
        String operate = req.getParameter("operate");
        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }
        //获取当前实例所有方法
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        //循环遍历
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);

            //调用当前方法
            if (operate.equals(declaredMethod.getName())) {
                try {
                    declaredMethod.invoke(o, req, resp);
                    //找到匹配的方法结束
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //未找到指定方法抛出异常
            new RuntimeException("找到不指定operate");

        }
    }
}
