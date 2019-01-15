package com.lieyan.Entity;

public class Circlecomment {
    private Integer commentid;
    private Integer circleid;
    private String openid;
    private String comment;
    private String cotime;

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCotime(String cotime) {
        this.cotime = cotime;
    }

    public Integer getCommentid() {

        return commentid;
    }

    public Integer getCircleid() {
        return circleid;
    }

    public String getOpenid() {
        return openid;
    }

    public String getComment() {
        return comment;
    }

    public String getCotime() {
        return cotime;
    }
}
