package com.test.tcpIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 类主要表示IP地址是 ipv4和ipv6的父类
 * InetAddress测试
 */
public class InetAddressDemo {
    public static void main(String[] args) throws  Exception {
        InetAddress local = null;
        InetAddress remote = null;
        local =InetAddress.getLocalHost();//得到本地InetAddress对象
        remote =InetAddress.getByName("www.mldnjava.cn");//得到远程InetAddress对象
        System.err.println("得到本地的ip"+local.getHostAddress());
        System.err.println("得到本地的mldnjava的ip"+remote.getHostAddress());
        System.err.println("得到本机是否可达"+local.isReachable(1000));
    }
}
