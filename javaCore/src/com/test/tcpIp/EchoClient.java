package com.test.tcpIp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost",8888);
        PrintStream out =null;//输出流向服务器发送信息
        BufferedReader buf=null;//接收服务器发送的消息
        System.out.println("客户端连接1"+System.currentTimeMillis());
        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));//接收键盘的数据
        out = new PrintStream(client.getOutputStream());//向服务器输送信息
        buf =new BufferedReader(new InputStreamReader(client.getInputStream()));//接收服务器输入信息
        System.out.println("客户端连接"+System.currentTimeMillis());
        boolean flag=true;//标志位表示客户端是否操作完毕
        while (flag){ //客户端循环操作ss
            System.out.println("输入信息");
            //在此处不间断接收信息
            String str = input.readLine();//从键盘接收数据
            out.println(str);
                //为bye也结束
                if("bye".equals(str)){
                    flag=false;
                }else {
                    String se = buf.readLine();
                    System.out.println(se);
                }
            }

        client.close();

        buf.close();

    }
}
