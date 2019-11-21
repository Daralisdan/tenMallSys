package com.cn.wanxi.utils.Test;


import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.utils.simpSQL.SQL;
import com.cn.wanxi.utils.simpSQL.config.Config;

import java.util.ArrayList;
import java.util.Date;

/**
 * 从实体到实体的增删查改测试
 * SQL不是亲儿子不想管
 */
public class Test {
    SQL simpleSQL = new SQL();

    @org.junit.Test
    public void add() {
        User user = new User(2047, "WanXi", "root", new Date());
        simpleSQL.add(user);
    }

    /*
        只能根据id删除
     */
    @org.junit.Test
    public void delete() {
        User user = new User(2048, "WanXi", "root", new Date());
        simpleSQL.delete(user);
    }

    /*
        只能根据id查询
     */
    @org.junit.Test
    public void select() {
        ArrayList<User> userArrayList = getExamples();

        userArrayList = simpleSQL.select(userArrayList);
        for (User iter : userArrayList) {
            System.out.println(iter);
        }
    }

    @org.junit.Test
    public void update() {
        ArrayList<User> userArrayList = getExamples();
        for (User iter : userArrayList) {
            System.out.println(iter);
        }
        for (User iter : userArrayList) {
            iter.setName("马小跳");
            iter.setPassword("password");
            iter.setDate(new Date());
            simpleSQL.update(iter);//boolean
        }
        //id未改变继续使用userArrayList
        userArrayList = simpleSQL.select(userArrayList);
        for (User iter : userArrayList) {
            System.out.println(iter);
        }
    }

    private ArrayList<User> getExamples() {
        ArrayList<User> userArrayList = new ArrayList<>();
        User user_01 = new User(1001, "WanXi", null, new Date());
        User user_02 = new User(5004, "XiWan", null, new Date());
        userArrayList.add(user_01);
        userArrayList.add(user_02);

        return userArrayList;
    }

    @org.junit.Test
    public void temp() {


        ArrayList<OrderLogEntity> list = new ArrayList<>();
        for(int i = 2;i < 5;++i){
            OrderLogEntity entity = new OrderLogEntity();
            entity.setId(i);
            list.add(entity);
        }

        list = simpleSQL.select(list);
        for(OrderLogEntity iter : list){
            System.out.println(iter);
        }
    }
}
