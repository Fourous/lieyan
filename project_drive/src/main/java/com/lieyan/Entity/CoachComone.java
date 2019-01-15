package com.lieyan.Entity;

public class CoachComone {
    private Integer commentid;
    private Integer tid;
    private String comment;
    private String cotime;
    private String avatar;
    private String nickname;

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCotime(String cotime) {
        this.cotime = cotime;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getCommentid() {

        return commentid;
    }

    public Integer getTid() {
        return tid;
    }

    public String getComment() {
        return comment;
    }

    public String getCotime() {
        return cotime;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }
}
