package com.test.Util;

import java.util.Arrays;

/**
 * 数组的操作
 */
public class ArrayTest {
    public static void main(String[] args){
        int s[] ={1,3,45,6,2,6};
         Arrays.sort(s);
        System.err.println(Arrays.toString(s));
        int t = Arrays.binarySearch(s,3);//检索数据位置
        System.err.println("3的位置为："+t);
        Arrays.fill(s,2,4,7);//在2到4的位置添加元素
        System.err.println(Arrays.toString(s));
    }
}
