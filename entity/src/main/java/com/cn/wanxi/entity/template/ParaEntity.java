package com.cn.wanxi.entity.template;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:11
 */
public class ParaEntity {

    private Integer id;
    private String name;
    private String options;
    private int seq;
    private int templateId;
    private int page;
    private int size;

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
