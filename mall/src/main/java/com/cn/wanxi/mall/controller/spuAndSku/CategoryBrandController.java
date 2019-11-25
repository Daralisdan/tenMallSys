//package com.cn.wanxi.mall.controller.spuAndSku;
//
//import com.cn.wanxi.entity.spuAndSku.WxTabCategoryBrand;
//import com.cn.wanxi.entity.spuAndSku.WxTabSku;
//import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
//import com.cn.wanxi.service.spuAndSku.CategoryBrandService;
//import net.minidev.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/brandfenlei")
//public class CategoryBrandController {
//    private static final String cuo = "id不存在";
//
//    @Autowired
//    private CategoryBrandService categoryBrandService;
//
//    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
//    public String insert(WxTabCategoryBrand wxTabCategoryBrand) {
//
//        int i = categoryBrandService.insert(wxTabCategoryBrand);
//
//        if (i >= 1) {
//            int code = 0;
//            String message = "新增成功";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        } else {
//            int code = 1;
//            String message = "新增失败";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        }
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(int brandid, int categoryid) {
//        if (" ".equals(brandid) && " ".equals(categoryid)) {
//            return cuo;
//        }
//        int i = categoryBrandService.deleteById(brandid, categoryid);
//
//        if (i >= 1) {
//            int code = 0;
//            String message = "删除成功";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        } else {
//            int code = 1;
//            String message = "删除失败";
//            JSONObject result = new JSONObject();
//            result.put("code", code);
//            result.put("message", message);
//            return result.toJSONString();
//        }
//    }
//
//    @RequestMapping(value = "/findById", method = RequestMethod.POST)
//    public WxTabCategoryBrand findbyid(int brandid, int categoryid) {
//        if (" ".equals(brandid) && " ".equals(categoryid)) {
//            System.out.println("id为空");
//        }
//        WxTabCategoryBrand wxTabCategoryBrand = categoryBrandService.findById(brandid, categoryid);
//
//        return wxTabCategoryBrand;
//    }
//}