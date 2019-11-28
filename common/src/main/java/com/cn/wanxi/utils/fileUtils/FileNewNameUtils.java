package com.cn.wanxi.utils.fileUtils;

import java.util.UUID;

/**
 * 【品牌图片上传】生成文件名
 * 2019/11/22,Create by yaodan
 */
public class FileNewNameUtils {
    /**
     * 获取文件后缀名
     *
     * @param fileName 源文件
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成UUID格式
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成新的文件名
     *
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileNewName(String fileOriginName) {
        String fileNewName = getUUID() + getSuffix(fileOriginName);
        return fileNewName;
    }

}
