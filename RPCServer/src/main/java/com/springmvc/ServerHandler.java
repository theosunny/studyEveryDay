package com.springmvc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

public class ServerHandler implements Runnable {

    private Socket socket;
    private Object service;



    public ServerHandler(Socket socket, Object service) {

        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            try {
                                /* 获取请求流，Server解析并获取请求*/
                // 构建对象输入流，从源中读取对象到程序中
                ObjectInputStream input = new ObjectInputStream(
                        socket.getInputStream());
                try {

                    System.out.println("\nServer解析请求 ： ");
                    String methodName = input.readUTF();
                    System.out.println("methodName : " + methodName);
                    // 泛型与数组是不兼容的，除了通配符作泛型参数以外
                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                    System.out.println(
                            "parameterTypes : " + Arrays.toString(parameterTypes));
                    Object[] arguments = (Object[]) input.readObject();
                    System.out.println("arguments : " + Arrays.toString(arguments));


                                    /* Server 处理请求，进行响应*/
                    ObjectOutputStream output = new ObjectOutputStream(
                            socket.getOutputStream());
                    try {
                        // service类型为Object的(可以发布任何服务)，故只能通过反射调用处理请求
                        // 反射调用，处理请求
                        Method method = service.getClass().getMethod(methodName,
                                parameterTypes);
                        Object result = method.invoke(service, arguments);
                        System.out.println("\nServer 处理并生成响应 ：");
                        System.out.println("result : " + result);
                        output.writeObject(result);
                    } catch (Throwable t) {
                        output.writeObject(t);
                    } finally {
                        output.close();
                    }
                } finally {
                    input.close();
                }
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
