package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.utils.fileUtils.FileUploadUtils;
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
@RequestMapping("/upload")
public class FileUploadController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Value("${spring.resources.static-locations}")
    private String path;

    @Value("${spring.mvc.static-path-pattern}")
    private String imageFileName;


    /**
     * @param file 要上传的文件
     * @return@RequestParam("fileName")
     */

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Msg fileUpload(MultipartFile file) {
        Msg msg;
        if (file != null && file.getSize() > 0) {
            FileUploadUtils fileUploadUtils = new FileUploadUtils();
            String fileName = file.getOriginalFilename();
            msg = fileUploadUtils.uploadUtil(file, path, fileName);
            if (msg.getCode() == 0) {
                msg = Msg.success().messageData(imageFileName + fileName);
            } else {
                msg = Msg.fail().messageData("图片上传失败");
            }
        } else {
            msg = Msg.fail().messageData("图片为空,请上传图片");
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
            return ResponseEntity.ok(resourceLoader.getResource(path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
