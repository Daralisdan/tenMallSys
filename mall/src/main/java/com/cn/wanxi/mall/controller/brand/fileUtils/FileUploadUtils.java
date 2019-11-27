package com.cn.wanxi.mall.controller.brand.fileUtils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 图片文件上传工具类
 * 2019/11/22,Create by yaodan
 */
public class FileUploadUtils {
    public static boolean upload(MultipartFile file, String path, String fileName) {
        //生成新的文件名
        String realName = path + "/" + FileNewNameUtils.getFileNewName(fileName);

        File dest = new File(realName);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        //保存文件
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
