package com.future;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        Client client = new Client();
        Data da = client.request("name");
        System.out.println("请求完毕");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        System.out.println("数据 = "+ da.getResult());
    }
}
