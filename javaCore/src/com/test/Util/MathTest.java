package com.test.Util;

public class MathTest {
    public static void main(String[] args){
        System.err.println(Math.pow(2,3));//2的三次方
        System.err.println(Math.floor(5.6));//取最小
        System.err.println(Math.ceil(5.6));//取最大
        System.err.println(Math.random());//0到1的随机数
        double f = Math.random()*10 ;
        System.err.println("f="+f);
        System.err.println( (int) f);//0到1的随机数
        System.err.println(Math.round(5.6));//四舍五入
    }
}
