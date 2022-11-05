package com.zx.book.dao.Imp;

import com.zx.book.dao.UserDAO;
import com.zx.book.pojo.User;
import com.zx.book.queryrunner.QueryRunnerUtils;
import com.zx.myssm.utils.ContUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @ClassName UserDAOImp
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 16:42
 * @Version 1.0
 */
public class UserDAOImp implements UserDAO {
    QueryRunner queryRunner = QueryRunnerUtils.getQueryRunner();
//登录方法 查询登录账户
    @Override
    public User login(String uname, String pwd) {
        try {
            String sql = "select * from t_user where uname=? and pwd =?";
            BeanHandler<User> beanHandler = new BeanHandler<>(User.class);

            return queryRunner.query(ContUtils.getConnections(), sql, beanHandler, uname, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
