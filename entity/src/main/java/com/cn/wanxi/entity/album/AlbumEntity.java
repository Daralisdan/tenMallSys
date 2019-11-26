package com.cn.wanxi.entity.album;

/**【图片库管理】：用于存储商品图片的空间，一个图片库（相册）下有多张图片
 * 数据表： wx_tab_album （相册表）
 *
 * 2019/11/18,Create by yaodan
 */

public class AlbumEntity {

    private  Integer id;

    private String title;

    private String image;

    private String imageItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageItems() {
        return imageItems;
    }

    public void setImageItems(String imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageItems='" + imageItems + '\'' +
                '}';
    }
}
