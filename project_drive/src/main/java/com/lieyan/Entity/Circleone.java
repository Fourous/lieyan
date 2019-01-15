package com.lieyan.Entity;
//单个说说封装的实体

import java.util.List;

public class Circleone {
    private Integer circleid;
    private String mess;
    private String time;
    private Integer like;
    private Integer unlike;
    private String image1;
    private String image2;
    private String image3;
    private String avatarurl;
    private String nickname;
    private List<Commentone> comment;

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(List<Commentone> comment) {
        this.comment = comment;
    }

    public Integer getCircleid() {

        return circleid;
    }

    public String getMess() {
        return mess;
    }

    public String getTime() {
        return time;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getUnlike() {
        return unlike;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Commentone> getComment() {
        return comment;
    }
}
