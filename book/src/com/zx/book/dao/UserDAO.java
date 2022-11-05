package com.zx.book.dao;

import com.zx.book.pojo.User;
import com.zx.book.queryrunner.QueryRunnerUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 16:38
 * @Version 1.0
 */
public interface UserDAO {

    //登入方法
     User login(String uname, String pwd);

}
