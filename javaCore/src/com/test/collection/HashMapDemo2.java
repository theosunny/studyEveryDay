package com.test.collection;

import java.util.*;

/**
 * map的标准输出,、
 * 1、采用Iterator方式。map集合中，就是由一个个map.entry组成的、
 * 2、采用foreach方式
 */
public class HashMapDemo2 {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("张三","22");
        map.put("张三feng","122");
        map.put("张三sha","12");
        Collection<Map.Entry<String,String>> set = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> me = iterator.next();
            System.err.println("key=："+me.getKey()+"   value="+me.getValue());

        }

        for (Map.Entry<String,String> me :map.entrySet()) {

            System.err.println("key=："+me.getKey()+"   value="+me.getValue());

        }

    }
}
