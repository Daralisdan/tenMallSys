package com.cn.wanxi.service.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.ISpuDao;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.service.spuAndSku.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ISpuServiceImpl implements ISpuService {

    @Autowired
    private ISpuDao iSpuDao;
    @Override
    public int insert(WxTabSpu wxTabSpu) {

        return iSpuDao.insert(wxTabSpu);
    }

    @Override
    public List<Map<String, Object>> queryAll() {

        return iSpuDao.queryAll();
    }

    @Override
    public WxTabSpu findById(int id) {
        return iSpuDao.findById(id);
    }

    @Override
    public WxTabSpu findByName(String name) {

        return iSpuDao.findByName(name);
    }

    @Override
    public int update(WxTabSpu wxTabSpu) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = wxTabSpu.getId();
        WxTabSpu byId = iSpuDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iSpuDao.update(wxTabSpu);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
    @Override
    public int deleteById(int id) {
        return iSpuDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> daishenheliebiao(WxTabSpu wxTabSpu, int page, int size) {
        return iSpuDao.daishenheliebiao(wxTabSpu,page,size);
    }

    @Override
    public int tijiaoshenhe(WxTabSpu wxTabSpu) {
        return iSpuDao.tijiaoshenhe(wxTabSpu);
    }

    @Override
    public int shenhechenggong(WxTabSpu wxTabSpu) {
        return iSpuDao.shenhechenggong(wxTabSpu);
    }

    @Override
    public List<Map<String, Object>> fenye(WxTabSpu wxTabSpu, int page, int size) {
        return iSpuDao.fenye(wxTabSpu,page,size);
    }



    @Override
    public int zong() {
        return iSpuDao.zong();
    }
}
