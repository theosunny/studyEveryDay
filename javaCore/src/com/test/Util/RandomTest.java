package com.test.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 取1000内的随机数，并且判断重复的记录数
 */
public class RandomTest {
    public static void main(String[] args){
        int[] s = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            //生成10以内的随机数
            int r = random.nextInt(1000);
//            System.err.println("随机数"+random.nextInt(10));
            s[i]=r;
        }
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            int num = 0;
            int in = s[i] ;
            for (int j = 0; j < s.length; j++) {
                if (in==s[j]){
                    in=s[i];
                    num ++ ;
                }
                if (num>2){
                    map.put(in,num);
                }
            }
        }
        System.out.println(map.toString());
    }

}
