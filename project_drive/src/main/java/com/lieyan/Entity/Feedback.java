package com.lieyan.Entity;

public class Feedback {
    String openid;
    String fbtxt;
    String fbtime;

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setFbtxt(String fbtxt) {
        this.fbtxt = fbtxt;
    }

    public void setFbtime(String fbtime) {
        this.fbtime = fbtime;
    }

    public String getOpenid() {

        return openid;
    }

    public String getFbtxt() {
        return fbtxt;
    }

    public String getFbtime() {
        return fbtime;
    }
}
