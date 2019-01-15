package com.lieyan.Entity;

//教练的排班表
public class Appointime {
    private Integer appointid;
    private Integer tid;
    private Integer week;
    private String time1;
    private String time2;
    private Integer personum;
    private Integer state;
    private Integer classnum;

    public void setClassnum(Integer classnum) {
        this.classnum = classnum;
    }

    public Integer getClassnum() {
        return classnum;
    }

    public void setAppointid(Integer appointid) {
        this.appointid = appointid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public void setPersonum(Integer personum) {
        this.personum = personum;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAppointid() {

        return appointid;
    }

    public Integer getTid() {
        return tid;
    }

    public Integer getWeek() {
        return week;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }


    public Integer getPersonum() {
        return personum;
    }

    public Integer getState() {
        return state;
    }
}
