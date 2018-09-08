package com.test.collection;

import java.util.*;

public class CollectionsDemo1 {
    public static void main(String[] args){
//        Collection  list set的父类
        //   Collections  集合操作的工具类

//        List
//        Set

//        HashMap
        //1、返回不可变集合
        List s = Collections.emptyList();
        Set se = Collections.emptySet();
//        s.add("1"); //运行报错,因为不可变集合不能add
      //2、为集合一次性加内容
        List<String>  lsit = new ArrayList<>();
         Collections.addAll(lsit,"1","2","3","1.5");
        System.err.println("一次性加入的数据为："+lsit);
        //3==、反转集合内容
        Collections.reverse(lsit);
        System.err.println("反转后集合为："+lsit);
        //检索集合位置
        int position = Collections.binarySearch(lsit,"1");
        System.err.println("检索位置为："+position);
        //集合排序
        Collections.sort(lsit);
        System.err.println("排序后为："+lsit);
        //交换指定位置 比如第一个和第三个互换
        Collections.swap(lsit,0,2);
        System.err.println("互换后："+lsit);
        //替换指定元素
        Collections.replaceAll(lsit,"1","15");
        System.err.println("ti换后："+lsit);


    }

}
