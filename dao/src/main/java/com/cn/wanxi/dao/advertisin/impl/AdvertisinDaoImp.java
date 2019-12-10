package com.cn.wanxi.dao.advertisin.impl;

import com.cn.wanxi.dao.advertisin.IAdvertisinDao;
import com.cn.wanxi.entity.advertisin.AdvertisinEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LeesonWong
 * @date 2019/11/29 0:41
 */
@Repository
public class AdvertisinDaoImp implements IAdvertisinDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String attrMapper = "id as id,name as name,position as position," +
            "DATE_FORMAT(start_time,'%Y-%m-%d %H:%i:%s') as startTime," +
            "DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s') as endTime," +
            "status as status,image as image,url as url,remarks as remarks";

    @Override
    public List<AdvertisinEntity> findAdvertisinAll() {
        String exeSQL = "select " + attrMapper + " from wx_tab_advertisin";
        List<AdvertisinEntity> list = jdbcTemplate.query(exeSQL, new BeanPropertyRowMapper<>(AdvertisinEntity.class));
        return list;
    }

    @Override
    public List<AdvertisinEntity> findByPosition(String position) {
        String exeSQL = "select " + attrMapper + " from wx_tab_advertisin where position = ?";
        List<AdvertisinEntity> list = jdbcTemplate.query(exeSQL, new Object[]{position}, new BeanPropertyRowMapper<>(AdvertisinEntity.class));
        return list;
    }

    @Override
    public AdvertisinEntity findById(int id) {
        String exeSQL = "select " + attrMapper + " from wx_tab_advertisin where id = ?";
        List<AdvertisinEntity> list = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<>(AdvertisinEntity.class));
        if (0 < list.size()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<AdvertisinEntity> findCondPage(int page, int size, String position) {
        String exeSQL = "select " + attrMapper + " from wx_tab_advertisin where position = ? limit " + (page - 1) * size + "," + size;
        List<AdvertisinEntity> list = jdbcTemplate.query(exeSQL, new Object[]{position}, new BeanPropertyRowMapper<>(AdvertisinEntity.class));
        return list;
    }

    @Override
    public Integer findCondPageSum(String position) {
        String exeSQL = "select count(*) from wx_tab_advertisin where position = ?";
        Object[] args = {position};
        Integer sum = jdbcTemplate.queryForObject(exeSQL,args,Integer.class);
        return sum;
    }

    @Override
    public boolean add(String position, String name, String startTime, String endTime, String status, String image, String url, String remarks) {
        String exeSQL = "insert into wx_tab_advertisin(position,name,start_time,end_time,status,image,url,remarks) values(?,?,?,?,?,?,?,?)";
        Object[] args = {position, name, startTime, endTime,status, image, url, remarks};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public boolean update(String position, String name, String startTime, String endTime, String status, String image, String url, String remarks, int id) {
        String exeSQL = "update wx_tab_advertisin set position = ?,name = ?,start_time = ?,end_time = ?,status = ?,image = ?,url = ?,remarks = ? where id = ?";
        Object[] args = {position, name, startTime, endTime, status, image, url, remarks, id};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public boolean delete(int id) {
        String exeSQL = "delete from wx_tab_advertisin where id = ?";
        int temp = jdbcTemplate.update(exeSQL, new Object[]{id});
        return 0 < temp;
    }
}
