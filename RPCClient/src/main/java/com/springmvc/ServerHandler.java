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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Object getService() {
        return service;
    }

    public void setService(Object service) {
        this.service = service;
    }

    public ServerHandler(Socket socket, Object port) {

        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream =null;
        ObjectOutputStream objectOutputStream = null;
        try {
            inputStream =  new ObjectInputStream(socket.getInputStream());
            System.out.println("\nServer解析请求 ： ");
            String methodName = inputStream.readUTF();
            System.out.println("methodName : " + methodName);
            // 泛型与数组是不兼容的，除了通配符作泛型参数以外
            Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
            System.out.println(
                    "parameterTypes : " + Arrays.toString(parameterTypes));
            Object[] arguments = (Object[]) inputStream.readObject();
            System.out.println("arguments : " + Arrays.toString(arguments));
/* Server 处理请求，进行响应*/
             objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            // service类型为Object的(可以发布任何服务)，故只能通过反射调用处理请求
            // 反射调用，处理请求
            Method method = service.getClass().getMethod(methodName, parameterTypes);
            Object res = method.invoke(service, arguments);
            System.out.println("\nServer 处理并生成响应 ：");
            System.out.println("result : " + res);
            objectOutputStream.writeObject(res);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
