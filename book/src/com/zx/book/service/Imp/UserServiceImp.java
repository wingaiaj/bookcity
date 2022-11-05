package com.zx.book.service.Imp;

import com.zx.book.dao.Imp.UserDAOImp;
import com.zx.book.dao.UserDAO;
import com.zx.book.pojo.User;
import com.zx.book.service.UserService;

/**
 * @ClassName UserServiceImp
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 16:53
 * @Version 1.0
 */
public class UserServiceImp implements UserService {
    //依赖注入
    UserDAO userDAO;
    //登录方法
    @Override
    public User Login(String uname, String pwd) {
        return userDAO.login(uname, pwd);
    }
}
