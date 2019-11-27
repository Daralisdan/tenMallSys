package com.cn.wanxi.dao.album.impl;

import com.cn.wanxi.dao.album.IAlbumDao;
import com.cn.wanxi.entity.album.AlbumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【图片库管理】：用于存储商品图片的空间，一个图片库（相册）下有多张图片
 * 数据表： wx_tab_album （相册表）
 * <p>
 * 2019/11/26,Create by lxh
 */
@Repository
public class AlbumDaoImpl implements IAlbumDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(AlbumEntity albumEntity) {
        String exeSQL ="insert into wx_tab_album(title,image,image_items) values(?,?,?)";
        Object args[] = {albumEntity.getTitle(),albumEntity.getImage(),albumEntity.getImageItems()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL ="select id,title,image,image_items as imageItems from wx_tab_album";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public AlbumEntity findById(int id) {
        String exeSQL ="select id,title,image,image_items as imageItems from wx_tab_album where id=?";
        AlbumEntity albumEntity = null;
        List<AlbumEntity> wxTabSkuu = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<AlbumEntity>(AlbumEntity.class));
        if (null != wxTabSkuu && wxTabSkuu.size() > 0) {
            albumEntity = wxTabSkuu.get(0);
        }
        return albumEntity;
    }

    @Override
    public int update(AlbumEntity albumEntity) {
        String exeSQL = "update  wx_tab_album set title=? , image=? ,image_items=? WHERE id=?";
        Object args[] ={albumEntity.getTitle(),albumEntity.getImage(),albumEntity.getImageItems(),albumEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_album WHERE id=?";
        int temp = jdbcTemplate.update(exeSQL, id);
        return temp;
    }
}
