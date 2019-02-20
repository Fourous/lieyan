package com.lieyan.Entity;

public class Teamform {
    private Integer tid;
    private String teamid;
    private String teamname;
    private String openid;
    private Integer formid;
    private Integer push;

    public void setPush(Integer push) {
        this.push = push;
    }

    public Integer getPush() {
        return push;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setFormid(Integer formid) {
        this.formid = formid;
    }

    public Integer getTid() {
        return tid;
    }

    public String getTeamid() {
        return teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public String getOpenid() {
        return openid;
    }

    public Integer getFormid() {
        return formid;
    }
}
