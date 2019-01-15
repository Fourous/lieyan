package com.lieyan.Entity;

public class Adver {
    private Integer adverid;
    private String txt;
    private String title;
    private String image2;
    private String image1;
    private String image3;
    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {

        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getTitle() {

        return title;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setAdverid(Integer adverid) {
        this.adverid = adverid;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public Integer getAdverid() {

        return adverid;
    }

    public String getTxt() {
        return txt;
    }

    public String getImage1() {
        return image1;
    }



}
