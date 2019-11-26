package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IReturnCauseDao;
import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.service.order.IReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IReturnCauseServiceImpl implements IReturnCauseService {
    @Autowired
    private IReturnCauseDao iReturnCauseDao;


    /**
     * 【根据id修改】
     *
     * @param returnCauseEntity
     * @return
     */
    @Override
    public int update(ReturnCauseEntity returnCauseEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = returnCauseEntity.getId();
        ReturnCauseEntity byId = iReturnCauseDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iReturnCauseDao.update(returnCauseEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }



    /**
     * 【根据id查询】
     *
     * @param id
     * @return
     */
    @Override
    public ReturnCauseEntity findById(int id) {
        return iReturnCauseDao.findById(id);
    }
}
