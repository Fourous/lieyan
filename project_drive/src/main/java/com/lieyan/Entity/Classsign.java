package com.lieyan.Entity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Classsign {
    private Integer classid;
    private Integer num;
    private Integer state;
    private Integer userstate;//这里涉及用户是否已经预约
    private List<String> username;

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Integer getClassid() {
        return classid;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getState() {
        return state;
    }

    public Integer getUserstate() {
        return userstate;
    }
}
