package com.cn.wanxi.mall.controller.spuAndSku;

import com.cn.wanxi.entity.spuAndSku.WxTabSku;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import com.cn.wanxi.utils.JDBC;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/product")
public class Controler {

    @RequestMapping(value ="/findSearch",method = RequestMethod.POST)
    public List<WxTabSpu> findSearchspu(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        List<WxTabSpu> list = new ArrayList<WxTabSpu>();
        List<WxTabSku> listl = new ArrayList<WxTabSku>();
        WxTabSku wxTabSku=null;
        String cc1= "select * from wx_tab_sku ";
        ResultSet rs1 = JDBC.query(cc1);
        String cc= "select * from wx_tab_spu";
        ResultSet rs = JDBC.query(cc);
        try {
            while (rs.next()){
                while (rs1.next()){
                    wxTabSku = new WxTabSku();
                    wxTabSku.setId(rs1.getInt("id"));
                    wxTabSku.setSn(rs1.getString("sn"));
                    wxTabSku.setName(rs1.getString("name"));

                    listl.add(wxTabSku);
                }
                WxTabSpu wxTabSpu = new WxTabSpu();
                wxTabSpu.setId(rs.getInt("id"));
                wxTabSpu.setSn(rs.getString("sn"));
                wxTabSpu.setName(rs.getString("name"));
                wxTabSpu.setSkuList(wxTabSku);
                list.add(wxTabSpu);
            }
        }catch (Exception e){
            System.out.println("cuo");
        }
        return list;
    }
    @RequestMapping(value ="/ShelvesReq",method = RequestMethod.POST)
    public String ShelvesReq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        int id = Integer.parseInt(request.getParameter("id"));
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setIs_marketable("1");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("1");
        int i=0;
        int b=0;
        String sql = "update wx_tab_spu set is_marketable= "+wxTabSpu.getIs_marketable()+ " where id = " + id + " ";
        String sqll = "update wx_tab_sku set status= "+wxTabSku.getStatus()+ " where id = " + id + " ";
        i = JDBC.update(sql);
        b = JDBC.update(sqll);
        if(i>0) {
            System.out.println(i);
            int code = 0;
            String message = "上架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "上架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/batchShelvesReq",method = RequestMethod.POST)
    public String batchShelvesReq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        String ids = request.getParameter("ids");
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setIs_marketable("1");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("1");
        String[] id = ids.split(",");
        int i=0;
        int b=0;
        int count=0;
        for ( int c=0; c<id.length; c++ ) {
            int di = Integer.parseInt(id[c]);
            String sql = "update wx_tab_spu set is_marketable= "+wxTabSpu.getIs_marketable()+ " where id = " + di + " ";
            String sqll = "update wx_tab_sku set status= "+wxTabSku.getStatus()+ " where id = " + di + " ";
            i = JDBC.update(sql);
            b = JDBC.update(sqll);
            count++;
        }
        System.out.println(count);
        if(i>0) {
            int code = 0;
            String message = "上架成功";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }else {
            int code = 1;
            String message = "上架失败";
            JSONObject result = new JSONObject();
            result.put("code",code);
            result.put("message",message);
            return  result.toJSONString();
        }
    }
    @RequestMapping(value ="/PullReq",method = RequestMethod.POST)
    public String PullReq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        int id = Integer.parseInt(request.getParameter("id"));
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setIs_marketable("2");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("2");
        String sql = "update wx_tab_spu set is_marketable= "+wxTabSpu.getIs_marketable()+ " where id = " + id + " ";
        String sqll = "update wx_tab_sku set status= "+wxTabSku.getStatus()+ " where id = " + id + " ";
        int  i = JDBC.update(sql);
        int  b = JDBC.update(sqll);
        if(i>0) {
            System.out.println(i);
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
    @RequestMapping(value ="/batchPullReq",method = RequestMethod.POST)
    public String batchPullReq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        String ids = request.getParameter("ids");
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setIs_marketable("2");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("2");
        String[] id = ids.split(",");
        int i=0;
        int b=0;
        for ( int c=0; c<id.length; c++ ) {
            int di = Integer.parseInt(id[c]);

            String sql = "update wx_tab_spu set is_marketable= "+wxTabSpu.getIs_marketable()+ " where id = " + di + " ";
            String sqll = "update wx_tab_sku set status= "+wxTabSku.getStatus()+ " where id = " + di + " ";
            i = JDBC.update(sql);
            b = JDBC.update(sqll);
        }
        if(i>0) {
            System.out.println(i);
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
    @RequestMapping(value ="/auditReq",method = RequestMethod.POST)
    public String submitReq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        String ids = request.getParameter("ids");
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setStatus("1");
        wxTabSpu.setIs_marketable("1");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("1");
        int di = Integer.parseInt(ids);
        String sql = "update wx_tab_spu set status = "+wxTabSpu.getStatus()+ " , is_marketable = "+wxTabSpu.getIs_marketable()+" where id = " + di + " ";
        String sqll = "update wx_tab_sku set status = "+wxTabSku.getStatus()+" where id = " + di + " ";

        int i = JDBC.update(sql);
        int b = JDBC.update(sqll);
        if(i>0) {
            System.out.println(i);
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
    @RequestMapping(value ="/submitReq",method = RequestMethod.POST)
    public String submitReqq(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        String ids = request.getParameter("ids");
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setStatus("9");
        int di = Integer.parseInt(ids);
        String sql = "update wx_tab_spu set status = "+wxTabSpu.getStatus()+ " where id = " + di + " ";
        int i = JDBC.update(sql);
        if(i>0) {
            System.out.println(i);
            int code = 0;
            String message = "提交";
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

    @RequestMapping(value ="/findById",method = RequestMethod.POST)
    public WxTabSpu lianchasku(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        int id = Integer.parseInt(request.getParameter("id"));
        String cc= "select * from wx_tab_sku where spu_id = "+id+" ";
        String cc1= "select * from wx_tab_spu where id = "+id+" ";
        WxTabSku wxTabSku = null;
        WxTabSpu wxTabSpu = null;

        ResultSet rs = JDBC.query(cc);
        ResultSet rs1 = JDBC.query(cc1);
        //  wxTabSpu.setId(Integer.parseInt(request.getParameter("id")));
        try {
            while (rs1.next()){
                while (rs.next()) {
                    wxTabSku = new WxTabSku();
                    wxTabSku.setId(rs.getInt("id"));
                    wxTabSku.setSn(rs.getString("sn"));
                    wxTabSku.setName(rs.getString("name"));
                }
                wxTabSpu = new WxTabSpu();
                wxTabSpu.setId(rs1.getInt("id"));
                wxTabSpu.setSn(rs1.getString("sn"));
                wxTabSpu.setName(rs1.getString("name"));
                wxTabSpu.setSkuList(wxTabSku);
            }
        }catch (Exception e){
            System.out.println("cuo");
        }
        return wxTabSpu;
    }
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public String insertskuspu(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setName(request.getParameter("name"));
        wxTabSku.setSn(request.getParameter("sn"));
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        try {
            Date date = new	Date(sdf.parse(request.getParameter("create_time")).getTime());
            wxTabSku.setCreate_time(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String cc1= "insert into wx_tab_sku(sn,name,create_time) values('"+wxTabSku.getSn()+"','"+wxTabSku.getName()+"','"+wxTabSku.getCreate_time()+"')";
        int b = JDBC.update(cc1);
        System.out.println(b);
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setName(request.getParameter("name"));
        wxTabSpu.setSn(request.getParameter("sn"));
        wxTabSpu.setSkuList(wxTabSku);
        String cc= "insert into wx_tab_spu(sn,name) values('"+wxTabSpu.getSn()+"','"+wxTabSpu.getName()+"')";
        int i = JDBC.update(cc);
        System.out.println(i);
        if(i==1) {
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
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public String deletespusku(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        int id = Integer.parseInt(request.getParameter("id"));

        String cc= "delete from wx_tab_spu  where id = "+id+" ";
        String cc1= "delete from wx_tab_sku  where id = "+id+" ";
        JDBC.update(cc1);
        int i = JDBC.update(cc);
        System.out.println(i);
        if(i==1) {
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
    public String updatespusku(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        WxTabSpu wxTabSpu = new WxTabSpu();
        wxTabSpu.setId(Integer.parseInt(request.getParameter("id")));
        wxTabSpu.setName(request.getParameter("name"));
        wxTabSpu.setSn(request.getParameter("sn"));
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setId(Integer.parseInt(request.getParameter("id")));
        wxTabSku.setName(request.getParameter("name"));
        wxTabSku.setSn(request.getParameter("sn"));
        String cc1= "update wx_tab_sku set sn= '"+wxTabSku.getSn()+"', name ='"+wxTabSku.getName()+"' where id = "+wxTabSku.getId()+" ";
        int b = JDBC.update(cc1);
        System.out.println(b);
        String cc= "update wx_tab_spu set sn= '"+wxTabSpu.getSn()+"', name ='"+wxTabSpu.getName()+"' where id = "+wxTabSpu.getId()+" ";
        int i = JDBC.update(cc);
        System.out.println(i);
        if(i==1) {
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
}
