package com.lieyan.Entity;

import java.io.Serializable;

public class Coach implements Serializable {
    private Integer tid;
    private String tname;
    private String gender;
    private String avatar;
    private String Introduce;
    private Integer islike;
    private Integer unlike;

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
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

    public String getTname() {
        return tname;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public Integer getLike() {
        return islike;
    }

    public Integer getUnlike() {
        return unlike;
    }
}
