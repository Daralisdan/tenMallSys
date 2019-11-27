package com.cn.wanxi.utils.jdbcTemplateSentence;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.user.UserEntity;
import com.cn.wanxi.utils.jdbcTemplateSentence.base.TimerMarker;
import com.cn.wanxi.utils.jdbcTemplateSentence.config.MappingConfig;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author LeesonWong
 * @date 2019/11/23 15:07
 */
public class SentenceTest {
    @Test
    public void test_01(){
//        MappingConfig.check();
    }

    @Test
    public void test_02(){
        UserEntity user = new UserEntity();
        user.setId(100);

        Field[] fields = UserEntity.class.getDeclaredFields();

        for(Field iter :fields){
            iter.setAccessible(true);
        }

        try {
            for(Field iter :fields){
                Object temp = iter.get(user);
                iter.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for(Field iter :fields){
            iter.setAccessible(false);
        }
    }

    @Test
    public void test_03(){
        HashMap<String, HashMap<String,String>> mapper = new HashMap<>();

        File dir = new File("src/main/java/com/cn/wanxi/utils/jdbcTemplateSentence/mapping");
        if(!dir.isDirectory()){
            System.err.println(TimerMarker.getTimer() + "未找到配置文件所在的文件夹");
        }
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
            System.out.println(iter.getName());
        }
    }

    @Test
    public void test_04(){
        SQLSentence sentence = SQLSentence.getInstance();
        CategoryEntity entity = new CategoryEntity();
//        entity.setIs_show(0);
        sentence.getSentenceByEntity(entity,SQLTypeEnum.INSERT);
    }

    @Test
    public void test_05(){
        String a = "CategoryEntity.properties";
        String[] arr = a.split("\\.");
        for(String iter : arr){
            System.out.println(iter);
        }
    }

    @Test
    public void test_06(){
        File tableName = new File("src\\main\\java\\com\\cn\\wanxi\\utils\\jdbcTemplateSentence\\nameMapper.properties");
        System.out.println(tableName.isFile());
        new MappingConfig();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(tableName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
