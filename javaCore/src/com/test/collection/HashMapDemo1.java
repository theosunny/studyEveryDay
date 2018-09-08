package com.test.collection;

import java.util.*;

/**
 * map的输出1
 */
public class HashMapDemo1 {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("张三","22");
        map.put("张三feng","122");
        map.put("张三sha","12");
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.err.println("输出全部的key："+iterator.next());

        }
        Collection<String> setV = map.values();
        Iterator<String> iteratorv = setV.iterator();
        while (iteratorv.hasNext()){
            System.err.println("输出全部的values："+iteratorv.next());

        }
    }
}
