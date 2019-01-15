package com.lieyan.Entity;

public class TeacherLogin {
    private Integer id;
    private Integer tid;
    private String username;
    private String passwd;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getId() {

        return id;
    }

    public Integer getTid() {
        return tid;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }
}
