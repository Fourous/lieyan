package com.lieyan.Entity;

public class Circlecol {
    private Integer colid;
    private Integer circleid;
    private String openid;
    private Integer like;
    private Integer unlike;

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }

    public Integer getColid() {

        return colid;
    }

    public Integer getCircleid() {
        return circleid;
    }

    public String getOpenid() {
        return openid;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getUnlike() {
        return unlike;
    }
}
