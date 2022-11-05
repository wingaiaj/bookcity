package com.zx.book.pojo;

/**
 * @ClassName User
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 15:56
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String uname;
    private String pwd;
    private String email;
    private Integer role;

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
