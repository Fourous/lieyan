package com.lieyan.Entity;

public class Comment {
    private Integer commentid;
    private Integer tid;
    private String openid;
    private String comment;
    private String cotime;

    public void setTid(Integer tid) {
        this.tid = tid;
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
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCommentid() {

        return commentid;
    }

    public Integer getTid() {

        return tid;
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
