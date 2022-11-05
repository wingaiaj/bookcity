package com.zx.book.service;

import com.zx.book.pojo.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 16:53
 * @Version 1.0
 */
public interface UserService {

    User Login(String uname, String pwd);
}
