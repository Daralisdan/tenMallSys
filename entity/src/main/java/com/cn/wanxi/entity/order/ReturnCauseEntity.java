package com.cn.wanxi.entity.order;

public class ReturnCauseEntity {
    private Integer id;
    private String cause;
    private Integer seq;
    private String  status;

    public ReturnCauseEntity(String cause, Integer seq, String status) {
        this.cause = cause;
        this.seq = seq;
        this.status = status;
    }
    public ReturnCauseEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
