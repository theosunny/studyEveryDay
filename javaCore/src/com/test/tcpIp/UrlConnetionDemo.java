package com.test.tcpIp;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * UrlConnetion是封装访问远程网络资源的方法类，他可以建立于远程访问的连接，检查远程资源的属性
 * 测试
 */
public class UrlConnetionDemo {
public static void main(String[] args) throws  Exception {
    URL url = new URL("http://www.mldnjava.cn");
    URLConnection c = url.openConnection();
  System.out.println("取得文件大小"+c.getContentLength());
  System.out.println("取得文件类型"+c.getContentType());
}
}
