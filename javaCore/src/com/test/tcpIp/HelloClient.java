package com.test.tcpIp;

import sun.misc.Cleaner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost",8888);
        BufferedReader buf =new BufferedReader(new InputStreamReader(client.getInputStream()));//取得客户端输入流
        String str =buf.readLine();
        System.err.println("服务器端输出内容为："+str);
      buf.close();
        client.close();

    }
}
