package com.lieyan.Entity;

import java.sql.Date;
public class Student {
    private Integer id;
    private String areaName;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;

    public Integer getAreaId() {
        return id;
    }

    public void setAreaId(Integer areaId) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

}