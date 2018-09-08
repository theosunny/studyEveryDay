package com.test.collection;

import java.util.*;

/**
 * 循环打印数据
 */
public class EnumerationDemo {
    public static void main(String[] args) {
        //只有vector里有elements方法，因为是老版本的，vector和list其实是差不多的
        Vector<String> list = new Vector<String>();
        list.add("hello");
        list.add("_");
        //列出所有list数据
        Enumeration<String> iterator = list.elements();
        while (iterator.hasMoreElements()) {
            String str = iterator.nextElement();
            System.err.println(str);

        }
        System.err.println("删除后的元素为：" + list);

        /**
         * foreach也可以打印
         */
        for (String str: list ) {
            System.err.println("str="+str);
        }
    }
}
