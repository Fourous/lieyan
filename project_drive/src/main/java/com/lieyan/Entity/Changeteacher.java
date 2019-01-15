package com.lieyan.Entity;

public class Changeteacher {
    private Integer id;
    private String openid;
    private Integer tid;
    private String reason;
    private String time;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {

        return id;
    }

    public String getOpenid() {
        return openid;
    }

    public Integer getTid() {
        return tid;
    }

    public String getReason() {
        return reason;
    }

    public String getTime() {
        return time;
    }
}
