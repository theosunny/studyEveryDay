package com.guardedSuspension;

import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue=requestQueue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("requestId:" + i + " thread_name " + Thread.currentThread().getName());

           System.out.println(Thread.currentThread().getName()+" requests "+request);
           requestQueue.addRequest(request);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is"+Thread.currentThread().getName());

        }
        System.out.println(Thread.currentThread().getName()+" end");
    }
}
