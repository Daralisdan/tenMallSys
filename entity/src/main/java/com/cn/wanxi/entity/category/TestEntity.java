package com.cn.wanxi.entity.category;

import java.util.Date;

/**
 * @author LeesonWong
 * @date 2019/11/26 23:09
 */
public class TestEntity {
    private Integer id;
    private String name;
    private Date updateTimer;

    public TestEntity() {
    }

    public TestEntity(Integer id, String name, Date updateTimer) {
        this.id = id;
        this.name = name;
        this.updateTimer = updateTimer;
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
        this.name = name;
    }

    public Date getUpdateTimer() {
        return updateTimer;
    }

    public void setUpdateTimer(Date updateTimer) {
        this.updateTimer = updateTimer;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updateTimer=" + updateTimer +
                '}';
    }
}
