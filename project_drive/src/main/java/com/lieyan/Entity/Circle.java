package com.lieyan.Entity;

public class Circle {
    private Integer circleid;
    private String openid;
    private String mess;
    private String time;
    private Integer like;
    private Integer unlike;

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
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

    private String image1;
    private String image2;
    private String image3;
    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public Integer getCircleid() {

        return circleid;
    }

    public String getOpenid() {
        return openid;
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
}
