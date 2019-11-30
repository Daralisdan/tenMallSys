package com.cn.wanxi.service.brand.impl;

import com.cn.wanxi.dao.brand.BrandDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.utils.fileUtils.FileUploadUtils;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author yaodan
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandDao brandDao;

    /**
     * 【添加品牌信息】
     *
     * @param brand
     * @return
     */
    @Override
    public Msg add(BrandEntity brand) {
        //判断页面传的值中名字不能为空
//        String name = brand.getName() != null ? brand.getName().trim() : "";
        Msg msg;
        //不为空时，添加数据
//        if (!StringUtils.isEmpty(name)) {
//            if (brand.getImageFile() != null && brand.getImageFile().getSize() > 0) {
//                FileUploadUtils fileUploadUtils = new FileUploadUtils();
//                Msg msgResult = fileUploadUtils.uploadUtil(brand.getImageFile(), path, imageFileName);
//                if (msgResult.getCode() == 0) {
//                    brand.setImage((String) msgResult.getRows());
//                } else {
//                    return Msg.fail().messageData("图片上传失败");
//                }
//            }
        if (brandDao.insert(brand) == 1) {
            msg = Msg.success().messageData("新增成功");
        } else {
            msg = Msg.fail().messageData("新增失败");
        }

        return msg;
    }

    /**
     * 【查询所有品牌信息】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return brandDao.queryAll();
    }

    /**
     * 【根据id查询】
     *
     * @param id
     * @return
     */
    @Override
    public BrandEntity findById(Integer id) {
        return brandDao.findById(id);
    }

    /**
     * 【根据id修改】
     *
     * @param brandEntity
     * @param
     * @return
     */
    @Override
    public Msg update(BrandEntity brandEntity) {
        Msg msg;
//        if (brandEntity.getImageFile() != null && brandEntity.getImageFile().getSize() > 0) {
//            FileUploadUtils fileUploadUtils = new FileUploadUtils();
//            Msg msgresule = fileUploadUtils.uploadUtil(brandEntity);
//            if (msgresule.getCode() == 0) {
//                brandEntity.setImage((String) msgresule.getRows());
//
//            } else {
//                return Msg.fail().messageData("上传图片失败");
//            }
//        }
        if (brandDao.update(brandEntity) == 1) {
            msg = Msg.success().messageData("修改成功");
        } else {
            msg = Msg.fail().messageData("修改失败");
        }
        return msg;
    }


    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return brandDao.deleteById(id);
    }


    /**
     * 【条件查询】
     *
     * @param brandEntity
     * @return
     */
    @Override
    public List<Map<String, Object>> findList(BrandEntity brandEntity) {
        return brandDao.findList(brandEntity);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */

    @Override
    public List<Map<String, Object>> findAllbyPage(int page, int size) {
        return brandDao.findAllbyPage(page, size);
    }

    /**
     * 统计所有数据
     *
     * @return
     */
    @Override
    public int countAll() {
        return brandDao.countAll();
    }

    /**
     * 【分页+查询】
     *
     * @param brandEntity
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Map<String, Object>> findListAndPage(BrandEntity brandEntity, int page, int size) {
        return brandDao.findListAndPage(brandEntity, page, size);
    }

    @Override
    public int adds(Map<String, BrandEntity> brandEntity) {
        return brandDao.adds(brandEntity);
    }

    @Override
    public int fileUpload(String realName) {
        return brandDao.fileUpload(realName);
    }


}
