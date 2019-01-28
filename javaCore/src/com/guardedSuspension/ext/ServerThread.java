package com.guardedSuspension.ext;

import com.future.FutureData;
import com.future.RealData;

public class ServerThread extends Thread {
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue=requestQueue;
    }
    @Override
    public void run() {
       while (true){
           final  Request request = requestQueue.getRequest();
           FutureData future = (FutureData) request.getResponse();
           RealData realData = new RealData(request.getName());
           future.setRealData(realData);
           System.out.println(Thread.currentThread().getName()+" handles "+request);
       }
    }
}
