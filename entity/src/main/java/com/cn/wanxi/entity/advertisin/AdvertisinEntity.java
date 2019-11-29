package com.cn.wanxi.entity.advertisin;


import java.sql.Date;

/**
 * @author LeesonWong
 * @date 2019/11/26 19:42
 */
public class AdvertisinEntity {
    private Integer id;
    private String name;
    private String position;
    private String startTime;
    private String endTime;
    private String status;
    private String image;
    private String url;
    private String remarks;

    public AdvertisinEntity() {
    }

    public AdvertisinEntity(Integer id, String name, String position, String startTime, String endTime, String status, String image, String url, String remarks) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.image = image;
        this.url = url;
        this.remarks = remarks;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "AdvertisinEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
