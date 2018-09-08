package com.springmvc;

public class RpcConsumer {
public static void main(String[] args) throws Exception{
    HelloService service =  RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
    String hello = service.hello("World");
    System.out.println("客户端收到远程调用的结果 ： " + hello);
}

}
