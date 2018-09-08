package com.test.tcpIp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp的服务端
 */
public class HelloServer {
    /**
     * 可以用 telnet open localhost 8888测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
    ServerSocket server= null;//声明server服务端对象
    Socket client =null; //定义客户端
    PrintStream ps =null;
    server = new ServerSocket(8888);//开放8888端口给客户
    System.out.println("服务器运行等待客户端连接");
    client =server.accept();//程序阻塞,等待客户端连接
    String str =  "hello";
    ps=new PrintStream(client.getOutputStream());//实例化打印流对象，输出信息
    ps.println(str);//输出信息
    ps.close();
    client.close();
    server.close();

}
}
