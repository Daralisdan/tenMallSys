/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Timer
 * Author:   Administrator
 * Date:     2019/12/3 15:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.menu;

import com.cn.wanxi.service.menu.IMenuService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/3
 * @since 1.0.0
 */
@Component
public class Timer {
       @Autowired
       private IMenuService iMenuService;
       private static final SimpleDateFormat dateFormat =new SimpleDateFormat("HH:mm:ss");
       @Scheduled(fixedRate = 1000*60*30)
       public void testTimer_01() throws IOException {
           String fileName="菜单信息.xls";
           List<Map<String, Object>> list = iMenuService.findAll();
           String aa = "菜单表";
           HSSFWorkbook workbook = new HSSFWorkbook();
           HSSFSheet sheet = workbook.createSheet();
// 添加标题
           String[] headers = {"菜单id", "菜单名称", "图标", "URL", "上级菜单ID"};
           HSSFRow row = sheet.createRow(0);
           for (int i = 0; i < headers.length; i++) {
               HSSFCell cell = row.createCell(i);
               HSSFRichTextString text = new HSSFRichTextString(headers[i]);
               cell.setCellValue(text);
               sheet.setColumnWidth(i,3000);
           }
           System.out.println(dateFormat);
//添加数据
           for(int i=0;i<list.size();i++){
               int rowNum = 0;
               Map<String, Object> menuEntity=list.get(i);
               HSSFRow row1 =sheet.createRow(i+1);
               HSSFCell cell=row1.createCell(rowNum++);
               cell.setCellValue(String.valueOf(menuEntity.get("id")));
               HSSFCell cell1=row1.createCell(rowNum++);
               cell1.setCellValue(String.valueOf(menuEntity.get("name")));
               HSSFCell cell2=row1.createCell(rowNum++);
               cell2.setCellValue(String.valueOf(menuEntity.get("icon")));
               HSSFCell cell3=row1.createCell(rowNum++);
               cell3.setCellValue(String.valueOf(menuEntity.get("url")));
               HSSFCell cell4=row1.createCell(rowNum);
               cell4.setCellValue(String.valueOf(menuEntity.get("parentId")));
           }
           FileOutputStream fos =new FileOutputStream("D:\\file\\menu\\menu.xls");
           workbook.write(fos);
           fos.write(workbook.getBytes());
           fos.close();
           workbook.close();
       }


}