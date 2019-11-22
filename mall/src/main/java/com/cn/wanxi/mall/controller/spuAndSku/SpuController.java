package com.cn.wanxi.mall.controller.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.service.spuAndSku.ISkuService;
import com.cn.wanxi.service.spuAndSku.ISpuService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class SpuController {
    private  static  final  String cuo = "id为空";
    private  static    Integer i = 0;
    private  static    Integer b = 0;
    @Autowired
    private ISpuService iSpuService;

    @Autowired
    private ISkuService iSkuService;

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public String insertskuspu(WxTabSpu wxTabSpu, WxTabSku wxTabSku){
        int i = iSpuService.insert(wxTabSpu);

        int b = iSkuService.insert(wxTabSku);
        if(i>=1&&b>=1) {
            int code = 0;
            String message = "新增成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "新增失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
//    @RequestMapping(value ="/adc",method = RequestMethod.POST)
//    public List<Map<String, Object>>  piliang(String ids){
//        return  iSkuService.testQueryForList(ids);
//    }
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public String delete(int id ){


        i = iSpuService.deleteById(id);
        b = iSkuService.deleteById(id);

        if(i==1&&b==1) {
            int code = 0;
            String message = "删除成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "删除失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public String update(WxTabSpu wxTabSpu, WxTabSku wxTabSku ){
        i = iSpuService.update(wxTabSpu);
        b = iSkuService.update(wxTabSku);
        if(i==1&&b==1) {
            int code = 0;
            String message = "更新成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "更新失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/findById",method = RequestMethod.POST)
    public WxTabSpu findid(int id){
        WxTabSpu wxTabSpu = iSpuService.findById(id);
        WxTabSku wxTabSku = iSkuService.findById(id);
        wxTabSpu.setSkuList(wxTabSku);
        return wxTabSpu;
    }
    @RequestMapping(value ="/findSearch",method = RequestMethod.POST)
    public List<Map<String, Object>> findSearch(){
        List<Map<String, Object>> list = iSpuService.queryAll();
        List<Map<String, Object>> cc = iSkuService.queryAll();

        return  list;
    }
    @RequestMapping(value ="/ShelvesReq",method = RequestMethod.POST)
    public String ShelvesReq(int id){
        if(" ".equals(id)){
            return cuo;
        }

        WxTabSku wxTabSku = iSkuService.findByIdzj(id);
        Integer spu_id = wxTabSku.getSpu_id();
        WxTabSpu wxTabSpu = iSpuService.findById(spu_id);
        String status = wxTabSpu.getStatus();
        if ("1".equals(status)) {
            iSkuService.shangjia(id);
            int code = 0;
            String message = "上架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        else {
            int code = 1;
            String message = "上架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/batchShelvesReq",method = RequestMethod.POST)
    public String batchShelvesReq(String id){
        String[] ids = null;
        if(id!=null&&id.trim()!=""){
        ids = id.split(",");
        }else {
            return cuo;
        }
        String status = null;
        WxTabSku wxTabSku =null;
        for (String bb:ids){
            if(bb!=null&&bb.trim()!="") {
                i = Integer.parseInt(bb);
                wxTabSku = iSkuService.findByIdzj(i);
                Integer spu_id = wxTabSku.getSpu_id();
                WxTabSpu wxTabSpu = iSpuService.findById(spu_id);
                status = wxTabSpu.getStatus();
            }
            else {
                return cuo;
            }
        }
        if ("1".equals(status)) {
            iSkuService.shangjia(i);
            int code = 0;
            String message = "上架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        else {
            int code = 1;
            String message = "上架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }

    }
    @RequestMapping(value ="/submitReq",method = RequestMethod.POST)
    public String submitReq(WxTabSpu wxTabSpu){
        int i = iSpuService.tijiaoshenhe(wxTabSpu);
        if(i>0) {

            int code = 0;
            String message = "提交成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "提交失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/auditReq",method = RequestMethod.POST)
    public String auditReq(WxTabSpu wxTabSpu){
        int i = iSpuService.shenhechenggong(wxTabSpu);
        if(i>0) {
            int code = 0;
            String message = "审核成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "审核失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/pullReq",method = RequestMethod.POST)
    public String pullReq(WxTabSku wxTabSku ){
        int i = iSkuService.xiajia(wxTabSku);
        if(i>0) {
            int code = 0;
            String message = "下架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "下架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }

    /**
     * 批量下架
     * @param id
     * @return
     */
    @RequestMapping(value ="/batchPullReq",method = RequestMethod.POST)
    public String batchPullReq(String id ){
        int i = iSkuService.piliangxiajia(id);
        if(i>0) {
            int code = 0;
            String message = "下架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "下架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
}
