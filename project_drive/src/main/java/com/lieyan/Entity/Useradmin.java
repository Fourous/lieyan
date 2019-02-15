package com.lieyan.Entity;

//这里是用户管理后台，主要利用用户名和密码进行验证登陆
//这里没有进行权限验证和分级
public class Useradmin {
    private Integer userid;
    private String username;
    private String userpasswd;

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpasswd() {
        return userpasswd;
    }
}
