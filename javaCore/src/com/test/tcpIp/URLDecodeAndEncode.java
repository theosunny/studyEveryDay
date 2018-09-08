package com.test.tcpIp;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url的编码，解码，主要处理中文用的多
 */
public class URLDecodeAndEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String key = "java 范悠扬";
        //编码
        String ekey =  URLEncoder.encode(key,"utf-8");
        System.err.println("编码，后"+ekey);
        String dkey = URLDecoder.decode(ekey,"utf-8");//解码
        System.err.println("解码，后"+dkey);

    }
}
