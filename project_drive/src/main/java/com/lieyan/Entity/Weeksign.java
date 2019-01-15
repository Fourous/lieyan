package com.lieyan.Entity;

import org.omg.CORBA.INTERNAL;

import java.util.List;

//这里封装传过去的7周的参数
public class Weeksign {
    private List<Classsign> classsigns;
//    private Integer weekid;

//    public void setWeekid(Integer weekid) {
//        this.weekid = weekid;
//    }
//
//    public Integer getWeekid() {
//        return weekid;
//    }

    public void setClasssigns(List<Classsign> classsigns) {
        this.classsigns = classsigns;
    }

    public List<Classsign> getClasssigns() {
        return classsigns;
    }
    //    private Integer weekid;//这里是对应的周几
//    private List<Integer> sta;//这里是4个时间对应的时候可以预约，0代表不能，1代表能
//    private List<Integer> pernum;//这里对应的是每个时间段对应的人数值
//
//    public void setWeekid(Integer weekid) {
//        this.weekid = weekid;
//    }
//
//    public void setSta(List<Integer> sta) {
//        this.sta = sta;
//    }
//
//    public void setPernum(List<Integer> pernum) {
//        this.pernum = pernum;
//    }
//
//    public Integer getWeekid() {
//        return weekid;
//    }
//
//    public List<Integer> getSta() {
//        return sta;
//    }
//
//    public List<Integer> getPernum() {
//        return pernum;
//    }
}