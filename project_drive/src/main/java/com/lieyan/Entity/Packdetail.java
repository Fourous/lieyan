package com.lieyan.Entity;

public class Packdetail {
    private Integer packid;
    private String packname;
    private String packdetail;
    private Integer price;

    public void setPackid(Integer packid) {
        this.packid = packid;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

    public void setPackdetail(String packdetail) {
        this.packdetail = packdetail;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPackid() {
        return packid;
    }

    public String getPackname() {
        return packname;
    }

    public String getPackdetail() {
        return packdetail;
    }

    public Integer getPrice() {
        return price;
    }
}
