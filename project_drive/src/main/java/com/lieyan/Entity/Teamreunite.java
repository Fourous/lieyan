package com.lieyan.Entity;
//这里组装数据
public class Teamreunite {
    private Integer tid;
    private String teamid;
    private String teamname;
    private String openid;
    private String name;
    private Integer push;
    private String avatarUrl;

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPush(Integer push) {
        this.push = push;
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

    public String getName() {
        return name;
    }

    public Integer getPush() {
        return push;
    }
}
