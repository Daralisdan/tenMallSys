/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MenuTreeNodeEntity
 * Author:   Administrator
 * Date:     2019/12/7 9:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.menu;

import com.cn.wanxi.entity.category.CategoryTreeNodeEntity;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
public class MenuTreeNodeEntity {
    private Integer id;
    private String name;
    private String url;
    private Integer parentId;
    private ArrayList<MenuTreeNodeEntity> children;

    public MenuTreeNodeEntity() {
    }

    public MenuTreeNodeEntity(Integer id, String name, String url, Integer parentId, ArrayList<MenuTreeNodeEntity> children) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.parentId = parentId;
        this.children = children;
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



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public ArrayList<MenuTreeNodeEntity> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<MenuTreeNodeEntity> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuTreeNodeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}