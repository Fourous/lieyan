package com.lieyan.Entity;

//学员的预约表
public class Userappoint {
    private Integer tid;
    private String openid;
    private Integer appointid;
    private String time;

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setAppointid(Integer appointid) {
        this.appointid = appointid;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTid() {

        return tid;
    }

    public String getOpenid() {
        return openid;
    }

    public Integer getAppointid() {
        return appointid;
    }

    public String getTime() {
        return time;
    }
}
