

import com.mysql.cj.Session;
import com.zx.qqzone.DAO.fruitDao;
import com.zx.qqzone.DAO.fruitDaoImp;
import com.zx.qqzone.pojo.Fruit;
import com.zx.qqzone.service.FruitService;
import com.zx.qqzone.service.FruitServiceImp;
import com.zx.myssm.utils.StringUtils;
import com.zx.myssm.view.ViewBaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName FruitController
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/17 9:16
 * @Version 1.0
 */
public class FruitController {

    FruitService fruitService = null;


    protected String add(String fname, Integer fprice, Integer fcount, String remark) {

        fruitService.addFruit(new Fruit(fname, fprice, fcount, remark));

        return "Redirect:fruit.do";
    }


    protected String del(Integer fid) {

        if (fid != null) {
            fruitService.delFruit(fid);
            return "Redirect:fruit.do";
        }
        return "error";
    }

    protected String edit(Integer fid, HttpServletRequest req) {

        if (fid != null) {

            Fruit fruit = fruitService.getFruit(fid);

            req.setAttribute("fruit", fruit);
            return "edit";
        }

        return "error";

    }


    public String index(Integer pageNo, String keyword, String op, HttpServletRequest req) {
        HttpSession session = req.getSession();


        if (null == pageNo) {
            pageNo = 1;
        }

        if (StringUtils.isNotEmpty(op) && "oper".equals(op)) {

            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
            }

            session.setAttribute("keyword", keyword);

        } else {

            Object keywordObj = session.getAttribute("keyword");

            if (keywordObj == null) {
                keyword = "";
            } else {
                keyword = (String) keywordObj;
            }
        }

        List<Fruit> fruitList = fruitService.getFruitList(pageNo, keyword);

        Long count = fruitService.getFruitCount(keyword);


        session.setAttribute("count", count);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("fruitList", fruitList);

        //????????????
        return "index";
    }

    protected String update(Integer fid, String fname, Integer fprice, Integer fcount, String remark) {

        fruitService.addFruit(new Fruit(fid, fname, fprice, fcount, remark));

        return "Redirect:fruit.do";
    }

}
