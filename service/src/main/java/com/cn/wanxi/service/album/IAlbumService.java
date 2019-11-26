package com.cn.wanxi.service.album;

import com.cn.wanxi.entity.album.AlbumEntity;

import java.util.List;
import java.util.Map;

/**【图片库管理】：用于存储商品图片的空间，一个图片库（相册）下有多张图片
 * 数据表： wx_tab_album （相册表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IAlbumService {

    int insert(AlbumEntity albumEntity);

    List<Map<String, Object>> queryAll();

    AlbumEntity findById(int id);

    int update(AlbumEntity albumEntity);

    int deleteById(int id);
}
