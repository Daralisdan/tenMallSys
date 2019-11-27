package com.cn.wanxi.service.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.ISkuDao;
import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.service.spuAndSku.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ISkuServiceImpl implements ISkuService {

    @Autowired
    private ISkuDao iSkuDao;

    @Override
    public int insert(WxTabSku wxTabSku) {

        return iSkuDao.insert(wxTabSku);
    }

    @Override
    public List<Map<String, Object>> queryAll() {

        return iSkuDao.queryAll();
    }

    @Override
    public WxTabSku findById(int id) {
        return iSkuDao.findById(id);
    }

    @Override
    public int update(WxTabSku wxTabSku) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = wxTabSku.getId();
        WxTabSku byId = iSkuDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iSkuDao.update(wxTabSku);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        return iSkuDao.deleteById(id);
    }

    @Override
    public int xiajia(WxTabSku wxTabSku) {

        return iSkuDao.xiajia(wxTabSku);
    }

    @Override
    public int piliangxiajia(String id) {
        return iSkuDao.piliangxiajia(id);
    }

    @Override
    public WxTabSku findByIdzj(int id) {

        return iSkuDao.findByIdzj(id);
    }

    @Override
    public int shangjia(int id) {
        return iSkuDao.shangjia(id);
    }

    @Override
    public WxTabSku findByName(String name) {

        return iSkuDao.findByName(name);
    }
}


