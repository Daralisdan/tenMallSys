package com.cn.wanxi.utils.jdbcTemplateSentence;

import com.cn.wanxi.utils.jdbcTemplateSentence.base.TimerMarker;
import com.cn.wanxi.utils.jdbcTemplateSentence.config.MappingConfig;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author LeesonWong
 * @date 2019/11/24 13:59
 */
@SuppressWarnings("all")
class SentenceHelper {
    private String entityName;
    private ArrayList<Field> valids;
    private LinkedHashMap<String,String> attributeMap;
    private SQLTypeEnum type;

    public SentenceHelper(final String entityName,final ArrayList<Field> valids,
                          final LinkedHashMap<String,String> attributeMap,final SQLTypeEnum type) {
        this.entityName = entityName;
        this.valids = valids;
        this.attributeMap = attributeMap;
        this.type = type;
    }

    public String generateSentence(){
        String sentence = "";
        switch (type){
            case INSERT:
                sentence = getInsertSentence();
                break;
            case DELETE:
                sentence = getDeleteSentence();
                break;
            case SELECT:
                sentence = getSelectSentence();
                break;
            case UPDATE:
                sentence = getUpdateSentence();
                break;
            case COUNT:
                sentence = getCountSentence();
                break;
        }

        return sentence;
    }

    private String getInsertSentence(){
        StringBuilder sentenceGenerator = new StringBuilder();

        /**
         * 确定SQL类型，找到表名
         */
        String tabName = MappingConfig.getTableName(entityName);
        if(null == tabName){
            System.err.println(TimerMarker.getTimer() + "没有找到对应的表名，请检查配置文件!");
            return "";
        }
        sentenceGenerator.append("insert into " + tabName);

        /**
         * 对应列
         */
        sentenceGenerator.append(" (");
        for(Field iter : valids){
            sentenceGenerator.append(attributeMap.get(iter.getName()) + ",");
        }
        sentenceGenerator.setCharAt(sentenceGenerator.length()-1,')');

        /**
         * 拼接占位符
         */
        sentenceGenerator.append(" values(");
        for(Field iter : valids){
            sentenceGenerator.append("?,");
        }
        sentenceGenerator.setCharAt(sentenceGenerator.length()-1,')');

        return sentenceGenerator.toString();
    }

    private String getDeleteSentence(){
        StringBuilder sentenceGenerator = new StringBuilder();
        /**
         * 确定SQL类型，找到表名
         */
        String tabName = MappingConfig.getTableName(entityName);
        if(null == tabName){
            System.err.println(TimerMarker.getTimer() + "没有找到对应的表名，请检查配置文件!");
            return "";
        }
        sentenceGenerator.append("delete from " + tabName);

        /**
         * 拼接占位符
         */
        sentenceGenerator.append(" where ");
        for(int i = 0;i < valids.size();++i){
            sentenceGenerator.append(attributeMap.get(valids.get(i).getName()) + " = ?");
            if(i + 1 != valids.size()){
                sentenceGenerator.append(" and ");
            }
        }

        return sentenceGenerator.toString();
    }

    private String getSelectSentence(){
        StringBuilder sentenceGenerator = new StringBuilder();
        /**
         * 确定SQL类型
         */
        String tabName = MappingConfig.getTableName(entityName);
        if(null == tabName){
            System.err.println(TimerMarker.getTimer() + "没有找到对应的表名，请检查配置文件!");
            return "";
        }
        sentenceGenerator.append("select ");
        for(String iter : attributeMap.keySet()){
            sentenceGenerator.append(attributeMap.get(iter) +" as " + iter + ",");
        }
        sentenceGenerator.setCharAt(sentenceGenerator.length()-1,' ');

        /**
         * 找到表名
         */
        sentenceGenerator.append("from " + tabName);

        /**
         * 拼接占位符
         */
        if(0 != valids.size()){
            sentenceGenerator.append(" where ");
            for(int i = 0;i < valids.size();++i){
                sentenceGenerator.append(attributeMap.get(valids.get(i).getName()) + " = ?");
                if(i + 1 != valids.size()){
                    sentenceGenerator.append(" and ");
                }
            }
        }

        return sentenceGenerator.toString();
    }

    //UPDATE wx_tab_category SET is_show = 0 where id = 1
    private String getUpdateSentence(){
        StringBuilder sentenceGenerator = new StringBuilder();
        /**
         * 确定SQL类型，找到表名
         */
        String tabName = MappingConfig.getTableName(entityName);
        if(null == tabName){
            System.err.println(TimerMarker.getTimer() + "没有找到对应的表名，请检查配置文件!");
            return "";
        }
        sentenceGenerator.append("update " + tabName);

        /**
         * 更新信息
         */
        sentenceGenerator.append(" set ");
        for(Field iter : valids){
            sentenceGenerator.append(attributeMap.get(iter.getName()) + "= ?,");
        }
        sentenceGenerator.setCharAt(sentenceGenerator.length()-1,' ');

        /**
         * 更新条件
         */
        // TODO: 2019/11/24 当前的情况只支持通过id修改，不一定有修改的必要，可以在业务层中解决这个问题
        sentenceGenerator.append("where id = ?");

        return sentenceGenerator.toString();
    }

    private String getCountSentence(){
        StringBuilder sentenceGenerator = new StringBuilder();

        /**
         * 标准计数
         */
        sentenceGenerator.append("select count(*) from ");

        /**
         * 插入表名
         */
        String tabName = MappingConfig.getTableName(entityName);
        sentenceGenerator.append(tabName);

        if(0 != valids.size()){
            /**
             * 查询条件
             */
            sentenceGenerator.append(" where ");
            for(int i = 0;i < valids.size();++i){
                sentenceGenerator.append(attributeMap.get(valids.get(i).getName()) + " = ?");
                if(i + 1 != valids.size()){
                    sentenceGenerator.append(" and ");
                }
            }
        }

        return sentenceGenerator.toString();
    }
}
