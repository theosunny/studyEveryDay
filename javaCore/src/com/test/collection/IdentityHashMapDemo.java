package com.test.collection;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 允许map的key重复
 */
public class IdentityHashMapDemo {
    public static void main(String[] args){
//        Map<Person,String> map = new HashMap<>();
        Map<Person,String> map = new IdentityHashMap<>();
        map.put(new Person("zs",12),"ce");
        map.put(new Person("ls",15),"ls");
        map.put(new Person("zs",12),"ls");
        for (Map.Entry<Person,String> me :map.entrySet()) {

            System.err.println("key=："+me.getKey()+"   value="+me.getValue());

        }
    }
}
