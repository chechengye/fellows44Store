package com.weichuang.web.pojo;

import java.io.Serializable;

public class Cart implements Serializable {

    private int id;
    private int count;
    private String uid;
    private String pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", pid='" + pid + '\'' +
                ", count=" + count +
                '}';
    }
}
