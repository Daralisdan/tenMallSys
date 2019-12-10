package com.cn.wanxi.service.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.ISkuDao;
import com.cn.wanxi.dao.spuAndSku.ISpuDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.service.spuAndSku.ISpuService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class ISpuServiceImpl implements ISpuService {

    @Autowired
    private ISpuDao iSpuDao;

    @Autowired
    private ISkuDao iSkuDao;
    @Override
    public Msg insert(WxTabSpu wxTabSpu) {
        Msg msg;
        if (!StringUtils.isEmpty(wxTabSpu)) {
            int result = iSpuDao.insert(wxTabSpu);
            List<WxTabSku> skuList = wxTabSpu.getSkuList();
            int cc = iSkuDao.insert(skuList);
            if (result >= 1 && cc >= 1) {
                msg = new Msg(0, "新增成功");
            }else  {
                msg = new Msg(1, "新增失败");
            }
        } else {
            msg = new Msg(1, "请确保spu和sku表的参数是正确的");
        }
        return msg;
    }

    @Override
    public List<Map<String, Object>> queryAll() {

        return iSpuDao.queryAll();
    }

    @Override
    public LinkedHashMap findById(Integer id) {
        LinkedHashMap linkedHashMap=null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            //判断是否有返回的数据
            WxTabSpu wxTabSpu = iSpuDao.findById(id);
            List<WxTabSku> wxTabSkuList = iSkuDao.findByIds(id);
            if (!ObjectUtils.isEmpty(wxTabSpu)) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("spu", wxTabSpu);
                linkedHashMap.put("skuList", wxTabSkuList);
            }
        }
        return linkedHashMap;
    }
    @Override
    public WxTabSpu findByName(String name) {

        return iSpuDao.findByName(name);
    }

    @Override
    public Msg update(WxTabSpu wxTabSpu) {
        Msg msg;
        //先根据id查询，当前数据是否存在
        int id = wxTabSpu.getId();
        WxTabSpu byId = iSpuDao.findById(id);
        if(byId==null){
            msg = new Msg(1, "id不存在");
            return msg;
        }
        //如果查询当前数据存在，则修改
        if (!StringUtils.isEmpty(id)) {
            int result = iSpuDao.update(wxTabSpu);
            List<WxTabSku> skuList = wxTabSpu.getSkuList();
            int cc = iSkuDao.update(skuList);
            if (result >= 1 && cc >= 1) {
                msg = new Msg(0, "更新成功");
            }else  {
                msg = new Msg(1, "更新失败");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }
    @Override
    public Msg deleteById(Integer id) {
        Msg msg;
        if (!StringUtils.isEmpty(id)) {
            int result = iSpuDao.deleteById(id);
            int cc = iSkuDao.deleteById(id);
            if (result >= 1 && cc >= 1) {
                msg = new Msg(0, "删除成功");
            }
            else  {
                msg = new Msg(1, "删除失败");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }

    @Override
    public Msg daishenheliebiao(Map<String, Object> param) {
        Object page = param.get("page");
        Object size = param.get("size");
        Object status = param.get("status");
        if(size==null||page==null){
            Msg msg = new Msg(1,"page或者size为空");

            return msg;
        }
        int i = Integer.parseInt(page.toString());
        int b = Integer.parseInt(size.toString());
        WxTabSpu wxTabSpu = new WxTabSpu();
        if(status!=null){
            wxTabSpu.setStatus(status.toString());
        }else {
            Msg msg = new Msg(1,"status状态必须输入9");

            return msg;
        }
        PageList pageList = new PageList();
         List<Map<String, Object>> list = iSpuDao.daishenheliebiao(wxTabSpu, i, b);
        return getMsg(i, b, pageList, list);
    }

    @Override
    public Msg tijiaoshenhe(WxTabSpu wxTabSpu) {
        Msg msg;
        if(wxTabSpu==null){
            msg = new Msg(1,"id不存在");
            return msg;
        }else {
            int result = iSpuDao.tijiaoshenhe(wxTabSpu);
            if (result == 1) {
                msg = new Msg(0, "提交成功");
            } else {
                msg = new Msg(1, "提交失败");
            }
        }
        return msg;
    }

    @Override
    public Msg shenhechenggong(Map<String,Integer> page) {
        Msg msg;
        Integer id = page.get("id");
        Integer type = page.get("type");
        if(id==null||type==null){
            msg = new Msg(0,"id或者type为空");
            return msg;
        }else {
            int result = iSpuDao.shenhechenggong(id);
            if (result == 1&&type == 0) {
                msg = new Msg(0, "审核成功");
            } else {
                msg = new Msg(1, "审核失败");
            }
        }
        return msg ;
    }

    @Override
    public Msg fenye(Map<String, Object> param) {

        Object page = param.get("page");
        Object size = param.get("size");
        Object name = param.get("name");
        if(size==null||page==null){
            Msg msg = new Msg(1,"page或者size为空");

            return msg;
        }
        int i = Integer.parseInt(page.toString());
        int b = Integer.parseInt(size.toString());
        WxTabSpu wxTabSpu = new WxTabSpu();
        if(name!=null){
            wxTabSpu.setName(name.toString());
        }
        PageList pageList = new PageList();
        List<Map<String, Object>> list = iSpuDao.daishenheliebiao(wxTabSpu, i, b);

        return getMsg(i, b, pageList, list);
    }



    @Override
    public int zong() {
        return iSpuDao.zong();
    }

    @Override
    public Msg list(Map<String,Integer> param) {
        Msg msg;
        Integer page = param.get("page");
        Integer size = param.get("size");
        if(page==null||size==null){
             msg = new Msg(0,"page和size为空");
            return msg;
        }else {
            msg = new Msg(1,"处理成功",iSpuDao.list(page,size));
        }
  return  msg;
    }
    @Override
    public Msg xiajia(WxTabSpu wxTabSpu) {
        Msg msg;
        if(wxTabSpu==null){
            msg = new Msg(1,"id不存在");
            return msg;
        }else {
            int result = iSpuDao.xiajia(wxTabSpu);
            if (result == 1) {
                msg = new Msg(0, "下架成功");
            } else {
                msg = new Msg(1, "下架失败");
            }
        }
        return msg;
    }

    @Override
    public Msg shangjia(Integer id) {
        Msg msg;
        if (!StringUtils.isEmpty(id)) {
            int result = iSpuDao.shangjia(id);
            if (result == 1) {
                msg = new Msg(0, "上架成功");
            } else {
                msg = new Msg(1, "上架失败");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }

    @Override
    public Msg piliangshangjia(String id) {
        Msg msg;
        if (!StringUtils.isEmpty(id)) {
            int result = iSpuDao.piliangshangjia(id);
            System.out.println(result);
            if (result >= 1) {
                msg = new Msg(0, "批量上架成功");
            } else {
                msg = new Msg(1, "批量上架失败");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }

    @Override
    public Msg piliangxiajia(String id) {
        Msg msg;
        if (!StringUtils.isEmpty(id)) {
            int result = iSpuDao.piliangxiajia(id);
            System.out.println(result);
            if (result >= 1) {
                msg = new Msg(0, "批量下架成功");
            } else {
                msg = new Msg(1, "批量下架失败");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }
    @Override
    public Msg fenyeye(Map<String, Integer> param) {
        Integer page = param.get("page");
        Integer size = param.get("size");
        if(size==null||page==null){
            Msg msg = new Msg(1,"page或者size为空");
            return msg;
        }
        PageList pageList = new PageList();
        List<Map<String, Object>> list = iSpuDao.fe1nye(page, size);
        return getMsg(page, size, pageList, list);
    }


    private Msg getMsg(int page, int size, PageList pageList, List<Map<String, Object>> list) {
        Msg msg;
        if (null != list && list.size() > 0) {
            //把查询出来的对象封装在分页实体类中
            pageList.setRows(list);
            //统计所有数据的总行数
            int totalRows =iSpuDao.zong();

            //把页数封装在分页实体类中
            pageList.setPage(page);
            pageList.setTotal(list.size());
            //查询出来的总行数封装在分页实体类中
            pageList.setTotalRows(totalRows);
            int pages = 0;

            if (totalRows % size == 0) {
                pages = totalRows / size;
            } else {
                pages = totalRows / size + 1;
            }
            System.out.println("目前分页的总页数是" + pages);
            //总页数
            pageList.setPages(pages);

            msg = new Msg(0, "查询成功", pageList);
        } else {
            msg = new Msg(1, "未查询到相关品牌的信息");
        }
        return msg;
    }
}
