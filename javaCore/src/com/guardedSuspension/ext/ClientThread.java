package com.guardedSuspension.ext;


import com.future.FutureData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    private List<Request> myRequest=new ArrayList<Request>();
    public ClientThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue=requestQueue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("requestId:" + i + " thread_name " + Thread.currentThread().getName());

           System.out.println(Thread.currentThread().getName()+" requests "+request);
           request.setResponse(new FutureData());
            requestQueue.addRequest(request);
            myRequest.add(request);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is"+Thread.currentThread().getName());

        }
        for (Request r:myRequest){
            System.out.println("currenr thread is "+Thread.currentThread().getName()+" response is"+ r.getResponse().getResult());
        }

    }
}
