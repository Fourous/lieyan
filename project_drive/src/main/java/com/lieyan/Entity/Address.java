package com.lieyan.Entity;

public class Address {
    private Integer id;
    private String name;
    private String address;
    private String introduce;
    private String iconPath;
    private float latitude;
    private float longitude;
    private Integer width;
    private Integer height;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIntroduce() {
        return introduce;
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
