package com.cn.wanxi.entity.brand;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 2019/11/15,Create by yaodan
 */
@Data
public class BrandEntity {
    //品牌id
    private Integer id;
    //品牌名称
    private String name;
    //品牌的首字母
    private String letter;
    //排序
    private Integer seq;

    //图片地址
    private String image;


}
