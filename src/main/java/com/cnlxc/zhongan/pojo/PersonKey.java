package com.cnlxc.zhongan.pojo;

public class PersonKey {
    private Integer id;

    private String name;

    private String username;

    public PersonKey(Integer id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public PersonKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}