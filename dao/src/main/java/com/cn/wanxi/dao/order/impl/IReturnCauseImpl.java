package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IReturnCauseDao;
import com.cn.wanxi.entity.order.ReturnCauseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IReturnCauseImpl implements IReturnCauseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int update(ReturnCauseEntity returnCauseEntity) {
        String sql = "update wx_tab_return_cause set status=?,seq=?,cause=? where id=?";
        Object args[] = {returnCauseEntity.getStatus(),returnCauseEntity.getSeq(),returnCauseEntity.getCause() , returnCauseEntity.getId()};
        int temp = jdbcTemplate.update(sql, args);
        return temp;
    }

    @Override
    public ReturnCauseEntity findById(int id) {
        ReturnCauseEntity returnCauseEntity = null;
        String exeSQL = "select id, cause,seq,status from wx_tab_return_cause where id=?";
        List<ReturnCauseEntity> returnCauseEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<ReturnCauseEntity>(ReturnCauseEntity.class));
        if (null != returnCauseEntities && returnCauseEntities.size() > 0) {
            returnCauseEntity = returnCauseEntities.get(0);
        }
        return returnCauseEntity;
    }

    @Override
    public int insert(ReturnCauseEntity returnCauseEntity) {
        String exeSQL = "INSERT INTO wx_tab_return_cause(cause,seq,status) VALUES(?,?,?)";
        Object args[] = {returnCauseEntity.getCause(),returnCauseEntity.getSeq(),returnCauseEntity.getStatus()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select cause,seq,status from wx_tab_return_cause";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_return_cause WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }
}
