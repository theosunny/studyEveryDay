package com.springmvc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统的io实现
 * server端首先创建了一个serverSocket来监听8000端口，
 * 然后创建一个线程，线程里面不断调用阻塞方法 serversocket.accept();获取新的连接，见(1)，
 * 当获取到新的连接之后，给每条连接创建一个新的线程，这个线程负责从该连接中读取数据，
 * 见(2)，然后读取数据是以字节流的方式，见(3)。

 作者：简书闪电侠
 链接：https://www.jianshu.com/p/a4e03835921a
 來源：简书
 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class IoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serversocket = new ServerSocket(8000);
            //(1)接收连接的主线程
            new Thread(() -> {
                while (true) {
                    try {
                        Socket socket = serversocket.accept();
                        new Thread(() -> {

                            byte[] data = new byte[1024];
                            try {
                                InputStream inputStream = socket.getInputStream();
                                while (true) {
                                    int len = 0;
                                    while ((len = inputStream.read(data)) != -1) {
                                        System.out.println(new String(data, 0, len));
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
