package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("_");
        //列出所有list数据
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            //使用iterator删除指定数据
            if("_".equals(iterator.next())){
                iterator.remove();
            }else{

                System.err.println(str);
            }

        }
        System.err.println("删除后的元素为："+list);
    }
}
