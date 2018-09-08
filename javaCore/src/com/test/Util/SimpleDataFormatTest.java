package com.test.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatTest {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss SSS");

       String s= sdf.format(new Date());
        System.err.println(s);
    }

}
