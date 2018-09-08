package com.springmvc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework {
    //暴露服务
public static void export(final Object service, int port) throws IOException {
    if (service==null){
        throw new IllegalArgumentException("参数异常");
    }
    if (port<=0||port>6379){
        throw new IllegalArgumentException("端口异常");
    }
    System.out.println("Export service " + service.getClass().getName() + " on port " + port);
   //服务建立
    ServerSocket  serverSocket = new ServerSocket(port);
    for (;;){
        final  Socket socket = serverSocket.accept();
        new Thread(new ServerHandler(socket,service)).start();

    }
}
}
