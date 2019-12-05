package com.cn.wanxi.mall.controller.brand;


import com.cn.wanxi.utils.fileUtils.FileUploadUtils;
import com.cn.wanxi.utils.utils.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【品牌图片上传】
 *
 * @author 2019/11/22,Create by yaodan
 */
@Api(tags = "图片上传接口")
@RestController
@RequestMapping("/brand")
public class FileUploadController {

    private final ResourceLoader resourceLoader;
    @Value("${spring.resources.static-locations}")
    private String path;
    @Value("${spring.mvc.static-path-pattern}")
    private String imageFileName;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    /**
     * @param file 要上传的文件
     * @return@RequestParam("fileName")
     */

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Msg fileUpload(MultipartFile file) {
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        return fileUploadUtils.uploadUtil(file, path, imageFileName);
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @PostMapping("show")
    public ResponseEntity showPhotos(String fileName) {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource(fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
