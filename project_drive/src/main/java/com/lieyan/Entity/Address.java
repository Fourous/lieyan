package com.lieyan.Entity;

public class Address {
    private Integer id;
    private String title;
    private String iconPath;
    private float latitude;
    private float longitude;
    private Integer width;
    private Integer height;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIconPath() {
        return iconPath;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
