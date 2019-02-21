package com.lieyan.Entity;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Form {
    private Integer fid;
    private String fname;
    private String ftel;
    private String fidcard;
    private String faddress;
    private String fqq;
    private String fwechat;
    private String fteacher;
    private String fpack;
    private String openid;

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setFpack(String fpack) {
        this.fpack = fpack;
    }

    public String getFpack() {
        return fpack;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public void setFidcard(String fidcard) {
        this.fidcard = fidcard;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public void setFqq(String fqq) {
        this.fqq = fqq;
    }

    public void setFwechat(String fwechat) {
        this.fwechat = fwechat;
    }

    public void setFteacher(String fteacher) {
        this.fteacher = fteacher;
    }

    public String getFname() {

        return fname;
    }

    public String getFtel() {
        return ftel;
    }

    public String getFidcard() {
        return fidcard;
    }

    public String getFaddress() {
        return faddress;
    }

    public String getFqq() {
        return fqq;
    }

    public String getFwechat() {
        return fwechat;
    }

    public String getFteacher() {
        return fteacher;
    }
}
