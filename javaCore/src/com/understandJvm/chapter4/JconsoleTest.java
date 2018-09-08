package com.understandJvm.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class JconsoleTest {
    public  static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
        }
    }
    static  class OOMObject{
        public byte[] placeholder = new byte[6*1024];
    }
    public static void main(String[] args) throws InterruptedException {
//        fillHeap(1000);
        String[] a = {"1","2"};
        List<String> s = Arrays.asList(a);
        a[1]="ss";

        System.out.println(s);
        List<String> as = new ArrayList<>();
        as.add("1");
        List<String> ss =as.subList(0,1);
        ss.add("2");
        System.out.println(as);
        as.add("3");
        System.out.println(ss);
    }
}
