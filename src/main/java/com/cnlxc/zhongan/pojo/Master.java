package com.cnlxc.zhongan.pojo;

import java.util.Date;

public class Master extends MasterKey {
    private String val1;

    private String val2;

    private String val3;

    private String val4;

    private String val5;

    private String val6;

    private String val7;

    private String val8;

    private String val9;

    private Date createTime;

    private Date updateTime;

    public Master(String key1, String key2, String key3, String key4, String key5, String key6, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9, Date createTime, Date updateTime) {
        super(key1, key2, key3, key4, key5, key6);
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
        this.val5 = val5;
        this.val6 = val6;
        this.val7 = val7;
        this.val8 = val8;
        this.val9 = val9;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Master() {
        super();
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1 == null ? null : val1.trim();
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2 == null ? null : val2.trim();
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3 == null ? null : val3.trim();
    }

    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4 == null ? null : val4.trim();
    }

    public String getVal5() {
        return val5;
    }

    public void setVal5(String val5) {
        this.val5 = val5 == null ? null : val5.trim();
    }

    public String getVal6() {
        return val6;
    }

    public void setVal6(String val6) {
        this.val6 = val6 == null ? null : val6.trim();
    }

    public String getVal7() {
        return val7;
    }

    public void setVal7(String val7) {
        this.val7 = val7 == null ? null : val7.trim();
    }

    public String getVal8() {
        return val8;
    }

    public void setVal8(String val8) {
        this.val8 = val8 == null ? null : val8.trim();
    }

    public String getVal9() {
        return val9;
    }

    public void setVal9(String val9) {
        this.val9 = val9 == null ? null : val9.trim();
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