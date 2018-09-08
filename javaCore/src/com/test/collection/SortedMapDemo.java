package com.test.collection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *SortedMap是排序的接口，只要实现了此接口的类都是排序的子类 ，TreeMap也是。
 */
public class SortedMapDemo {
    public static void main(String[] args){
        SortedMap<String,String> sortedMap = new TreeMap<>();
        sortedMap.put("zs","ls");
        sortedMap.put("a","ls1");
        sortedMap.put("bs","ls2");
        sortedMap.put("aas","ls3");
        System.err.println("第一个集合对应的key："+sortedMap.firstKey());
        System.err.println("第一个集合对应的values："+sortedMap.get(sortedMap.firstKey()));
        System.err.println("最后一个集合对应的key："+sortedMap.lastKey());
        System.err.println("最后第一个集合对应的values："+sortedMap.get(sortedMap.lastKey()));
        //部分集合
        System.err.println("所有数据：");
        for (Map.Entry<String,String> e:sortedMap.entrySet()) {
            System.err.println("key="+e.getKey()+"   values="+e.getValue());
        }
        //部分集合
        System.err.println("指定范围内的集合为");
        for (Map.Entry<String,String> e:sortedMap.subMap("a","bs").entrySet()) {
            System.err.println("key="+e.getKey()+"   values="+e.getValue());
        }
        //返回小于指定范围集合
        System.err.println("返回小于指定范围集合");
        for (Map.Entry<String,String> e:sortedMap.headMap( "bs").entrySet()) {
            System.err.println("key="+e.getKey()+"   values="+e.getValue());
        }
        //部分集合
        System.err.println("返回大于指定范围集合");
        for (Map.Entry<String,String> e:sortedMap.tailMap("a" ).entrySet()) {
            System.err.println("key="+e.getKey()+"   values="+e.getValue());
        }
    }
}
