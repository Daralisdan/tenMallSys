package com.cn.wanxi.mall.controller.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.service.spuAndSku.ISkuService;
import com.cn.wanxi.service.spuAndSku.ISpuService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
    public String insertskuspu(@RequestBody WxTabSpu wxTabSpu){
        int i = iSpuService.insert(wxTabSpu);
        List<WxTabSku> skuList = wxTabSpu.getSkuList();
        int b = iSkuService.insert(skuList);
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
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/delete",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String delete(@RequestBody  WxTabSpu wxTabSpu ){
        Integer id = wxTabSpu.getId();
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
    public String update(@RequestBody WxTabSpu wxTabSpu, WxTabSku wxTabSku ){
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
     * @param
     * @return
     */
    @RequestMapping(value ="/findById",method = RequestMethod.POST)
    public LinkedHashMap findid(@RequestBody WxTabSpu wxTabSpuu){
        int id = wxTabSpuu.getId();
        WxTabSpu wxTabSpu = iSpuService.findById(id);
        List<WxTabSku> wxTabSkuList = iSkuService.findByIds(id);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("spu",wxTabSpu);
        linkedHashMap.put("skuList",wxTabSkuList);
        return linkedHashMap;
    }


    @RequestMapping(value ="/spuList",method = RequestMethod.POST)
    public LinkedHashMap spuList( @RequestBody Map<String, Integer> param ){
        Integer page = param.get("page");
        Integer size = param.get("size");
        WxTabSpu wxTabSpu = new WxTabSpu();
        List<Map<String, Object>> list = iSpuService.fenye(wxTabSpu, page, size);
        int count = iSpuService.zong();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("row",list);
        linkedHashMap.put("total",count);
        return linkedHashMap;
    }

    @RequestMapping(value ="/findSpuPage",method = RequestMethod.POST)
    public LinkedHashMap spufenye(@RequestBody Map<String, Integer> param){
        Integer page = param.get("page");
        Integer size = param.get("size");
        WxTabSpu wxTabSpu = new WxTabSpu();
        List<Map<String, Object>> list = iSpuService.fenye(wxTabSpu, page, size);
        int count = iSpuService.zong();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("row",list);
        linkedHashMap.put("total",count);
        return linkedHashMap;
    }
    /**
     * 待审核列表
     * @return
     */
    @RequestMapping(value ="/findAuditALL",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public LinkedHashMap daishenghebiao(@RequestBody  Map<String, Integer> param){
        Integer page = param.get("page");
        Integer size = param.get("size");
        Integer status = param.get("status");
        WxTabSpu wxTabSpu = new WxTabSpu();
        if (status != null) {
            wxTabSpu.setStatus(status.toString());
        }else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("status","状态不存在");
            return linkedHashMap;
        }
        List<Map<String, Object>> list = iSpuService.daishenheliebiao(wxTabSpu, page, size);
        int count = iSpuService.zong();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("row",list);
        linkedHashMap.put("total",count);
        return linkedHashMap;
    }
    /**
     * 根据商品的id 然后查到spu表然后判断其状态是否为已审核，然后更改商品的状态
     * @param
     * @return
     */
    @RequestMapping(value ="/ShelvesReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String ShelvesReq(@RequestBody Map<String, Integer> param){
        Integer id = param.get("id");
        Integer type = param.get("type");
        if(type==0){
            int code = 1;
            String message = "上架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        if(id==null){
            return cuo;
        }
        i = iSpuService.shangjia(id);
        if (i>0&&type==1) {
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
     * @param page
     * @return
     */
    @RequestMapping(value ="/batchShelvesReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String batchShelvesReq(@RequestBody Map<String,String> page){
        String id = page.get("id");
        if(id==null){
            return cuo;
        }
        i = iSpuService.piliangshangjia(id);
        if (i>0) {
            iSkuService.shangjia(i);
            int code = 0;
            String message = "批量上架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
        else {
            int code = 1;
            String message = "批量上架失败";
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
    public String submitReq(@RequestBody WxTabSpu wxTabSpu){
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
    public String auditReq(@RequestBody WxTabSpu wxTabSpu){
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
    public String pullReq(@RequestBody WxTabSku wxTabSku ){
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
     * @param page
     * @return
     */
    @RequestMapping(value ="/batchPullReq",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String batchPullReq(@RequestBody Map<String,String> page ){
        String id = page.get("id");
        if(id==null){
            return cuo;
        }
        int i = iSpuService.piliangxiajia(id);
        if(i>0) {
            int code = 0;
            String message = "批量下架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "批量下架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
//    @RequestMapping(value ="/testFindSearch",method = RequestMethod.POST)
//    public LinkedHashMap testFindSearch( @RequestBody Map<String, Integer> param ){
//        Integer page = param.get("page");
//        Integer size = param.get("size");
//
//        /**
//         * 满足条件的spu
//         */
//        WxTabSpu wxTabSpu = new WxTabSpu();
//        List<Map<String, Object>> list = iSpuService.fenye(wxTabSpu, page, size);
//
//        /**
//         * id数组
//         */
//        ArrayList<Integer> idList = new ArrayList<>();
//        for(Map<String, Object> iter : list){
//            idList.add((Integer) iter.get("id"));
//        }
//
//        HashMap<Integer,Object> idToSku = new HashMap<>();
//        for(Integer id  : idList){
//            iSkuService.findById(id);
//        }      
//
//        int count = iSpuService.zong();
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        linkedHashMap.put("row",list);
//        linkedHashMap.put("total",count);
//        return linkedHashMap;
//    }

    @RequestMapping(value ="/findSearch",method = RequestMethod.POST)
    public Map<String, Object> testlFindSearch( @RequestBody Map<String, Integer> param ){
        Integer page = param.get("page");
        Integer size = param.get("size");
        Map<String, Object> list = iSpuService.list(page, size);
        int zong = iSpuService.zong();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("spu",list);
        linkedHashMap.put("total",zong);
        return list;
    }
}
