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
public class SpuAndSkuController {
    private  static  final  String cuo = "id不存在";
    private  static    Integer i = 0;
    private  static    Integer b = 0;
    @Autowired
    private ISpuService iSpuService;

    @Autowired
    private ISkuService iSkuService;

    /**
     * 查询spu表的所有内容
     * @param
     * @return
     */
    @RequestMapping(value ="/queryAllSpu",method = RequestMethod.POST)
    public List<Map<String, Object>>  queryAllSpu(){
        List<Map<String, Object>> list = iSpuService.queryAll();
        return list;
    }

    /**
     * 根据spu表的名字查询
     * @param name
     * @return
     */
    @RequestMapping(value ="/findBySpuName",method = RequestMethod.POST)
    public WxTabSpu  findBySpuName(String name ){
        WxTabSpu wxTabSpu = iSpuService.findByName(name);
        return wxTabSpu;
    }

    /**
     * 根据sku表的名字查询
     * @param name
     * @return
     */
    @RequestMapping(value ="/findBySkuName",method = RequestMethod.POST)
    public WxTabSku  findBySkuName(String name){
        WxTabSku wxTabSku = iSkuService.findByName(name);
        return wxTabSku;
    }
    /**
     * 查询sku表的所有内容
     * @param
     * @return
     */
    @RequestMapping(value ="/queryAllSku",method = RequestMethod.POST)
    public List<Map<String, Object>>  queryAllSku(){
        List<Map<String, Object>> list = iSkuService.queryAll();
        return list;
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST ,produces="text/plain;charset=UTF-8")
    public String insertskuspu(WxTabSpu wxTabSpu, WxTabSku wxTabSku){

        int i = iSpuService.insert(wxTabSpu);
        System.out.println(i);
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
    /**
     * 根据id删除spu和sku表
     * @param id
     * @return
     */
    @RequestMapping(value ="/delete",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String delete(int id ){

        i = iSpuService.deleteById(id);
        b = iSkuService.deleteById(id);
        if(i>=1&&b>=1) {
            int code = 0;
            String message = "删除spu和sku成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();

        }
        if(i>=1){
            int code = 0;
            String message = "删除spu成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        if(b>=1){
            int code = 0;
            String message = "删除sku成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        else {
            int code = 1;
            String message = "删除失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }

    /**
     * 根据更新sku表和spu表
     * @param wxTabSpu
     * @param wxTabSku
     * @return
     */
    @RequestMapping(value ="/update",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String update(WxTabSpu wxTabSpu, WxTabSku wxTabSku ){
        i = iSpuService.update(wxTabSpu);
        b = iSkuService.update(wxTabSku);
        if(i>=1&&b>=1) {
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
    /**
     * 根据spu的id查询spu表和sku表
     * @param id
     * @return
     */
    @RequestMapping(value ="/findById",method = RequestMethod.POST)
    public WxTabSpu findid(int id){

        WxTabSpu wxTabSpu = iSpuService.findById(id);
        WxTabSku wxTabSku = iSkuService.findById(id);
        wxTabSpu.setSkuList(wxTabSku);

        return wxTabSpu;
    }

//    @RequestMapping(value ="/findById",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
//    public WxTabSpu findid(int[] id){
//        WxTabSpu wxTabSpu = iSpuService.findById(id);
//        WxTabSku wxTabSku = iSkuService.findById(id);
//        wxTabSpu.setSkuList(wxTabSku);
//        return wxTabSpu;
//    }


    @RequestMapping(value ="/findSearch",method = RequestMethod.POST)
    public List<Map<String, Object>> findSearch(){
        List<Map<String, Object>> list = iSpuService.queryAll();
        List<Map<String, Object>> cc = iSkuService.queryAll();

        return  list;
    }
    @RequestMapping(value ="/findSpuPage",method = RequestMethod.POST)
    public List<Map<String, Object>> spufenye(int page,int size){
        List<Map<String, Object>> list = iSpuService.fenye(page,size);
        int count = iSpuService.zong();
        JSONObject result = new JSONObject();
        result.put("list",list);
        result.put("total",count);
        return  list;
    }
    /**
     * 待审核列表
     * @return
     */
    @RequestMapping(value ="/findAuditALL",method = RequestMethod.POST)
    public List<Map<String, Object>> daishenghebiao(){
        List<Map<String, Object>> list = iSpuService.daishenheliebiao();
        return  list;
    }
    /**
     * 根据商品的id 然后查到spu表然后判断其状态是否为已审核，然后更改商品的状态
     * @param id
     * @return
     */
    @RequestMapping(value ="/ShelvesReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String ShelvesReq(int id){
        if(" ".equals(id)){
            return cuo;
        }
        WxTabSku wxTabSku = iSkuService.findByIdzj(id);
        Integer spu_id = wxTabSku.getSpuId();
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
    /**
     * 根据许多商品的id 然后查到spu表然后判断其状态是否为已审核，然后更改商品的状态
     * @param id
     * @return
     */
    @RequestMapping(value ="/batchShelvesReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String batchShelvesReq(String id){

        if(id==null&&id.trim()==""){
            return cuo;
        }
        String[] ids = id.split(",");
        String status = null;
        WxTabSku wxTabSku =null;
        for (String bb:ids){
            if(bb==null&&bb.trim()=="") {
               return cuo;
            }
            i = Integer.parseInt(bb);
            wxTabSku = iSkuService.findByIdzj(i);
            Integer spu_id = wxTabSku.getSpuId();
            WxTabSpu wxTabSpu = iSpuService.findById(spu_id);
            status = wxTabSpu.getStatus();
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

    /**
     * 根据id更改它的状态
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/submitReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
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

    /**
     *根据id 然后更改审核审核状态和是否上架
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/auditReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
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
    /**
     * 根据商品的 id 更改状态为下架
     * @param wxTabSku
     * @return
     */
    @RequestMapping(value ="/pullReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
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
    @RequestMapping(value ="/batchPullReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String batchPullReq(String id ){
        if(id==null&&id.trim()==""){
            return cuo;
        }
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
