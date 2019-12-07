package com.cn.wanxi.mall.controller.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.service.spuAndSku.ISkuService;
import com.cn.wanxi.service.spuAndSku.ISpuService;
import com.cn.wanxi.utils.utils.Msg;
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

    @RequestMapping(value ="/add",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg insertskuspu(@RequestBody WxTabSpu wxTabSpu){
       return iSpuService.insert(wxTabSpu);
    }
    /**
     * 根据id删除spu和sku表
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/delete",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg delete(@RequestBody WxTabSpu wxTabSpu ){
        Integer id = wxTabSpu.getId();
        return iSpuService.deleteById(id);
    }

    /**
     * 根据更新sku表和spu表
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/update",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg update(@RequestBody WxTabSpu wxTabSpu){
      return iSpuService.update(wxTabSpu);
    }
    /**
     * 根据spu的id查询spu表和sku表
     * @param
     * @return
     */
    @RequestMapping(value ="/findById",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public LinkedHashMap findid(@RequestBody WxTabSpu wxTabSpuu){
        int id = wxTabSpuu.getId();
        return iSpuService.findById(id);
    }

    @RequestMapping(value ="/spuList",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg spuList( @RequestBody Map<String, Integer> param ){
        return iSpuService.fenyeye(param);
    }

    @RequestMapping(value ="/findSpuPage",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg spufenye(@RequestBody Map<String, Object> param){
        return iSpuService.fenye(param);
    }
    /**
     * 待审核列表
     * @return
     */
    @RequestMapping(value ="/findAuditALL",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg daishenghebiao(@RequestBody  Map<String, Object> param){
        return iSpuService.daishenheliebiao(param);
    }
    /**
     * 根据商品的id 然后查到spu表然后判断其状态是否为已审核，然后更改商品的状态
     * @param
     * @return
     */
    @RequestMapping(value ="/shelvesReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg ShelvesReq(@RequestBody Map<String, Integer> param){
        Integer id = param.get("id");
        return  iSpuService.shangjia(id);

    }
    /**
     * 根据许多商品的id 然后查到spu表然后判断其状态是否为已审核，然后更改商品的状态
     * @param page
     * @return
     */
    @RequestMapping(value ="/batchShelvesReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg batchShelvesReq(@RequestBody Map<String,String> page){
        String id = page.get("id");
     return iSpuService.piliangshangjia(id);
    }

    /**
     * 根据id更改它的状态,提交审核
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/submitReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg submitReq(@RequestBody WxTabSpu wxTabSpu){
        return iSpuService.tijiaoshenhe(wxTabSpu);
    }

    /**
     *根据id 然后更改审核审核状态和是否上架
     * @param page
     * @return
     */
    @RequestMapping(value ="/auditReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg auditReq(@RequestBody Map<String,Integer> page ){
        return  iSpuService.shenhechenggong(page);
    }
    /**
     * 根据商品的 id 更改状态为下架
     * @param wxTabSpu
     * @return
     */
    @RequestMapping(value ="/pullReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg pullReq(@RequestBody WxTabSpu wxTabSpu ){
       return iSpuService.xiajia(wxTabSpu);
    }
    /**
     * 批量下架
     * @param page
     * @return
     */
    @RequestMapping(value ="/batchPullReq",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public Msg batchPullReq(@RequestBody Map<String,String> page ){
        String id = page.get("id");
        return iSpuService.piliangxiajia(id);
    }


    @RequestMapping(value ="/findSearch",method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public  Msg testlFindSearch( @RequestBody Map<String, Integer> param ){
        return iSpuService.list(param);
    }
}
