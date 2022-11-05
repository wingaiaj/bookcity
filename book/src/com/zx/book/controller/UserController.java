package com.zx.book.controller;

import com.zx.book.pojo.User;
import com.zx.book.service.UserService;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 16:34
 * @Version 1.0
 */
//注册当前controller
public class UserController {
    //依赖注入
    UserService userService;
    public String login(String uname, String pwd) {
        //需要service方法 获取当前用户
        User user = userService.Login(uname, pwd);

        return "index";
    }
}
