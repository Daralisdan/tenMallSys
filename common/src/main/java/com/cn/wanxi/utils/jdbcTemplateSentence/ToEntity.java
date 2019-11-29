package com.cn.wanxi.utils.jdbcTemplateSentence;

import com.cn.wanxi.utils.jdbcTemplateSentence.base.TimerMarker;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author LeesonWong
 * @date 2019/11/26 17:14
 */
public class ToEntity {

    public static Object transMapToEntity(LinkedHashMap<String, String> map,Class entityClass){
        Object result = null;
        try {
            result = entityClass.newInstance();

            Field[] fields = entityClass.getDeclaredFields();

            for(Field iter : fields){
                if(map.containsKey(iter.getName())){
                    iter.setAccessible(true);
                    String gottenValue = map.get(iter.getName());
                    Object setValue = null;
                    switch(iter.getType().getSimpleName()){
                        case "Integer":
                            setValue = new Integer(Integer.parseInt(gottenValue));
                            break;
                        case "Character":
                            if(gottenValue.length() > 0){
                                setValue = Character.valueOf(gottenValue.charAt(0));
                            }
                            break;
                        case "Boolean":
                            setValue = new Boolean(gottenValue);
                            break;
                        case "String":
                            setValue = gottenValue;
                            break;
                        default:
                            break;
                    }

                    if(null == setValue){
                        iter.setAccessible(false);
                        System.err.println(TimerMarker.getTimer() + "无效值或者未包括的类型！");
                        return null;
                    }
                    iter.set(result,setValue);
                    iter.setAccessible(false);
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
