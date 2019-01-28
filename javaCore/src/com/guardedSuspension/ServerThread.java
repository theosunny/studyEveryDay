package com.guardedSuspension;

import java.util.concurrent.TimeUnit;

public class ServerThread extends Thread {
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue,String name){
        super(name);
        this.requestQueue=requestQueue;
    }
    @Override
    public void run() {
       while (true){
           final  Request request = requestQueue.getRequest();
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+" handles "+request);
       }
    }
}
