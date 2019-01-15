package com.lieyan.Entity;

public class Personcol {
    private Integer tid;
    private String openid;
    private Integer islike;
    private Integer unlike;

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setLike(Integer islike) {
        this.islike = islike;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }

    public Integer getTid() {

        return tid;
    }

    public String getOpenid() {
        return openid;
    }

    public Integer getLike() {
        return islike;
    }

    public Integer getUnlike() {
        return unlike;
    }

    public void personcol(Integer tid,String openid,Integer islike,Integer unlike){
        this.tid=tid;
        this.openid=openid;
        this.islike=islike;
        this.unlike=unlike;
    }
}
