package com.springmvc;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework{
    //暴露服务
public static <T> T refer(final Class<T>  interfaceClass, final String host, final int port) throws IOException {
    if (interfaceClass == null) {
        throw new IllegalArgumentException("Interface class == null");
    }
    // JDK 动态代理的约束，只能实现对接口的代理
    if (!interfaceClass.isInterface()){
        throw new IllegalArgumentException(
                "The " + interfaceClass.getName() + " must be interface class!");
    }
    if (host == null || host.length() == 0) {
        throw new IllegalArgumentException("Host == null!");
    }
    if (port <= 0 || port > 65535) {
        throw new IllegalArgumentException("Invalid port " + port);
    }
    System.out.println(
            "Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);

    // JDK 动态代理

    T proxy = (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class<?>[]{interfaceClass},new ClientHandler(host,port));
    return proxy;
}
}
