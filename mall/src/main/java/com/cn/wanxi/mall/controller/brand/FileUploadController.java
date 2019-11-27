package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.mall.controller.brand.fileUtils.FileUploadUtils;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【品牌图片上传】
 *
 * @author 2019/11/22,Create by yaodan
 */
@RestController
@RequestMapping("/brand")
public class FileUploadController {

    private final ResourceLoader resourceLoader;

    @Autowired
    private IBrandService iBrandService;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    //获取文件路径

    @Value("${web.upload-path}")
    private String path;


    /**
     * @param file 要上传的文件
     * @return@RequestParam("fileName")
     */

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Msg fileUpload(MultipartFile file) {
        if (file == null) {
            return Msg.success().messageData("空");
        }
        Msg msg = null;
        if (file.isEmpty()) {
            msg = Msg.fail().messageData("文件不存在");
        }
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            boolean upload = FileUploadUtils.upload(file, path, fileName);
            if (upload) {
                msg = Msg.success().messageData("images");
            }else{
                msg = Msg.success().messageData("IO错误");
            }
        }
        return msg;
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName) {

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
