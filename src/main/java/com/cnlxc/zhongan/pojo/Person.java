package com.cnlxc.zhongan.pojo;

import java.util.Date;

public class Person extends PersonKey {
    private Integer age;

    private String sex;

    private String hometown;

    private String single;

    private String diploma;

    private String graduatedSchool;

    private String company;

    private String withChildren;

    private Double height;

    private Double weight;

    private Date createTime;

    private Date updateTime;

    public Person(Integer id, String name, String username, Integer age, String sex, String hometown, String single, String diploma, String graduatedSchool, String company, String withChildren, Double height, Double weight, Date createTime, Date updateTime) {
        super(id, name, username);
        this.age = age;
        this.sex = sex;
        this.hometown = hometown;
        this.single = single;
        this.diploma = diploma;
        this.graduatedSchool = graduatedSchool;
        this.company = company;
        this.withChildren = withChildren;
        this.height = height;
        this.weight = weight;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Person() {
        super();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single == null ? null : single.trim();
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma == null ? null : diploma.trim();
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool == null ? null : graduatedSchool.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getWithChildren() {
        return withChildren;
    }

    public void setWithChildren(String withChildren) {
        this.withChildren = withChildren == null ? null : withChildren.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}