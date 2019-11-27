package com.cn.wanxi.utils.jdbcTemplateSentence.base;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU的简单实现，即最长时间没有被访问的元素被淘汰
 *
 * @author LeesonWong
 * @date 2019/11/23 22:06
 */
public class FixedCapacityMap {
    /**
     * 我也不知道这个地方有没有必要设计成单例
     */
//    private FixedCapacityMap() {
//    }
//
//    private static FixedCapacityMap instance = new FixedCapacityMap();
//    private static int capacity;
//
//    public static FixedCapacityMap getInstance(int size) {
//        capacity = size;
//        return instance;
//    }

    protected Map<String, String> fixedCapacityCache = Collections.synchronizedMap(new LRUHashMap<>());

    public String get(String key) {
        return fixedCapacityCache.get(key);
    }

    // TODO: 2019/11/25 这个方法需要研究是否上锁
    public synchronized void put(String key, String value) {
        fixedCapacityCache.put(key, value);
    }

    public boolean containsKey(String key) {
        return fixedCapacityCache.containsKey(key);
    }

    public int size() {
        return fixedCapacityCache.size();
    }

    static class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int capacity = 1024;
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
