package com.springmvc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler implements InvocationHandler {
    String host;
    int port;


    public ClientHandler(String host, int port) {
        this.host = host;
        this.port = port;

    }

    // invoke方法本意是对目标方法的增强，在这里用于发送RPC请求和接收响应
    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments)
            throws Throwable {
        // 创建Socket客户端，并与服务端建立链接
        Socket socket = new Socket(host, port);
        try {
                        /* 客户端像服务端进行请求，并将请求参数写入流中*/
            // 将对象写入到对象输出流，并将其发送到Socket流中去
            ObjectOutputStream output = new ObjectOutputStream(
                    socket.getOutputStream());
            try {
                // 发送请求
                System.out.println("\nClient发送请求 ： ");
                output.writeUTF(method.getName());
                System.out.println("methodName : " + method.getName());
                output.writeObject(method.getParameterTypes());
                System.out.println("parameterTypes : " + Arrays.toString(method
                        .getParameterTypes()));
                output.writeObject(arguments);
                System.out.println("arguments : " + Arrays.toString(arguments));


                            /* 客户端读取并返回服务端的响应*/
                ObjectInputStream input = new ObjectInputStream(
                        socket.getInputStream());
                try {
                    Object result = input.readObject();
                    if (result instanceof Throwable) {
                        throw (Throwable) result;
                    }
                    System.out.println("\nClient收到响应 ： ");
                    System.out.println("result : " + result);
                    return result;
                } finally {
                    input.close();
                }
            } finally {
                output.close();
            }
        } finally {
            socket.close();
        }
    }
}
