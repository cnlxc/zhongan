package com.cnlxc.zhongan.pojo;

public class MasterKey {
    private String key1;

    private String key2;

    private String key3;

    private String key4;

    private String key5;

    private String key6;

    public MasterKey(String key1, String key2, String key3, String key4, String key5, String key6) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key5 = key5;
        this.key6 = key6;
    }

    public MasterKey() {
        super();
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1 == null ? null : key1.trim();
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2 == null ? null : key2.trim();
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3 == null ? null : key3.trim();
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4 == null ? null : key4.trim();
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5 == null ? null : key5.trim();
    }

    public String getKey6() {
        return key6;
    }

    public void setKey6(String key6) {
        this.key6 = key6 == null ? null : key6.trim();
    }
}