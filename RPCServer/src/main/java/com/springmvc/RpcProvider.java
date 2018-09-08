package com.springmvc;

import java.io.IOException;

public class RpcProvider {
    public static void main(String[] args) throws IOException {
        HelloService helloService = new HelloServiceImpl();
        // RPC框架将服务暴露出来，供客户端消费
        RpcFramework.export(helloService, 1234);
    }
}
