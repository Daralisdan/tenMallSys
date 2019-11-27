package com.cn.wanxi.utils.jdbcTemplateSentence.config;

import com.cn.wanxi.utils.jdbcTemplateSentence.base.OrderProperties;
import com.cn.wanxi.utils.jdbcTemplateSentence.base.TimerMarker;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author LeesonWong
 * @date 2019/11/23 14:30
 */
public class MappingConfig {
    /**
     * 开发记录
     * 2019年11月25日09:33:45
     * 静态代码块读取没有成功，因此将该类设计成单例
     */

    /**
     * 实体名到表名的映射
     */
    private static HashMap<String,String> nameMapper = new HashMap<>();
    private static HashMap<String, LinkedHashMap<String,String>> mapper = new HashMap<>();

    /**
     * 扫描mapping文件夹中所有的properties文件
     * 将所有键对值注入到map中
     */
    static{
        /**
         * 本来想读取到文件文件之后才开始初始化资源
         * 放在这里比较方便，妥协了妥协了
         */
        // TODO: 2019/11/24 完善之后得换个位置
        InputStream in;
        OrderProperties properties;

        /**
         * 表名映射
         */
        try{
            properties = new OrderProperties();
            File nameMapperEntitytoTable = ResourceUtils.getFile("classpath:nameMapper.properties");
            in = new BufferedInputStream(new FileInputStream(nameMapperEntitytoTable));
            properties.load(in);
            for(Object iter : properties.keySet()){
                nameMapper.put((String)iter,(String)properties.get(iter));
            }

            File dir = ResourceUtils.getFile("classpath:mapping");
            if(!dir.isDirectory()){
                System.err.println(TimerMarker.getTimer() + "未找到配置文件所在的文件夹");
            }else{
                /**
                 * 匿名对象自动转化为lamda表达式
                 * 指定读取后缀名为properties的文件
                 */
                File[] files = dir.listFiles((dir1, name) -> {
                    //把dir 和name都封装到一个文件对象里
                    File file = new File(dir1, name);
                    return file.isFile() && file.getName().endsWith(".properties");
                });

                for(File iter : files){
                    /**
                     * 这里在切割字串的时候处理了转义字符问题
                     */
                    String tempName = iter.getName();
                    String entityName = tempName.split("\\.")[0];
                    LinkedHashMap<String,String> attributeMap = new LinkedHashMap<>();
                    properties = new OrderProperties();
                    in = new BufferedInputStream(new FileInputStream(iter));
                    properties.load(in);
                    for(Object entityAttribute : properties.keySet()){
                        attributeMap.put((String)entityAttribute,(String)properties.get(entityAttribute));
                    }
                    mapper.put(entityName,attributeMap);
                }
            }

        } catch (IOException e) {
            System.err.println();
            e.printStackTrace();
        }

        /**
         * 自此将所有的映射文件读取到
         *
         * mapper中
         * 虽然properties文件没有问题，但总是觉得有点low
         */
        // TODO: 2019/11/24 将properties映射实体与数据库表的方法改变为xml
    }

    public static LinkedHashMap<String,String> getAttributeMap(String entityName){
        return mapper.get(entityName);
    }

    public static String getTableName(String entityName){
        return nameMapper.get(entityName);
    }

    /**
     * 开发测试
     */
    @Deprecated
    public static void check(){
        for(String iter : mapper.keySet()){
            System.out.println(iter + "\t" + mapper.get(iter));
        }
    }
}
