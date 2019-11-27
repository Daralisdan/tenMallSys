package com.cn.wanxi.service.album.impl;

import com.cn.wanxi.dao.album.IAlbumDao;
import com.cn.wanxi.entity.album.AlbumEntity;
import com.cn.wanxi.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 【图片库管理】：用于存储商品图片的空间，一个图片库（相册）下有多张图片
 * 数据表： wx_tab_album （相册表）
 * <p>
 * 2019/11/18,Create by yaodan
 */
@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private IAlbumDao iAlbumDao;

    @Override
    public int insert(AlbumEntity albumEntity) {
        return iAlbumDao.insert(albumEntity);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return iAlbumDao.queryAll();
    }

    @Override
    public AlbumEntity findById(int id) {
        return iAlbumDao.findById(id);
    }

    @Override
    public int update(AlbumEntity albumEntity) {
        return iAlbumDao.update(albumEntity);
    }

    @Override
    public int deleteById(int id) {
        return iAlbumDao.deleteById(id);
    }
}
