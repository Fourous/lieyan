package com.lieyan.Entity;

public class Score {
    private Integer id;
    private Integer age;
    private String name;
    private Integer scoresum;
    private Integer scoreage;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScoresum(Integer scoresum) {
        this.scoresum = scoresum;
    }

    public void setScoreage(Integer scoreage) {
        this.scoreage = scoreage;
    }

    public int getId() {

        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getScoresum() {
        return scoresum;
    }

    public Integer getScoreage() {
        return scoreage;
    }
}
