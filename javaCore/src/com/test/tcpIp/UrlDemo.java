package com.test.tcpIp;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * url统一资源定位fu，可以直接连接到互联网获取指定文件、
 * 测试
 */
public class UrlDemo {
public static void main(String[] args) throws  Exception {
    URL url = new URL("http","www.mldnjava.cn",80,"/index.html");
//    URL url = new URL("http","www.baidu.com",80,"");
    InputStream in = url.openStream();
    Scanner scanner = new Scanner(in);
    scanner.useDelimiter("\n");
    while (scanner.hasNext()){
        System.out.println(scanner.next());
    }
}
}
