package com.cn.wanxi.utils.fileUtils;

import com.cn.wanxi.utils.utils.Msg;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 图片文件上传工具类
 * 2019/11/22,Create by yaodan
 */


public class FileUploadUtils {

    public Msg uploadUtil(MultipartFile file, String path, String imageFileName) {
        if (file == null) {
            return new Msg(1, "文件为空");
        }

        if (file.isEmpty()) {
            return new Msg(1, "文件不存在");
        }
        Msg msg;
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String realName = imageFileName + "/" + FileNewNameUtils.getFileNewName(fileName);

            boolean upload = upload(file, path + realName);
            if (upload) {
                msg = new Msg(0, realName);

            } else {
                msg = new Msg(1, "IO错误");
            }
        } else {
            msg = new Msg(1, "图片错误！");
        }
        return msg;
    }

    public boolean upload(MultipartFile file, String realName) {

        File dest = new File(realName);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
            try {
                //创建文件
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
