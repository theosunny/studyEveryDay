package com.guardedSuspension;

import java.util.LinkedList;

public class RequestQueue {
    private  LinkedList queue =new LinkedList();
    public synchronized Request getRequest(){
        while (queue.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (Request) queue.remove();
    }
    public synchronized void addRequest(Request request){
        queue.addLast(request);
        notifyAll();
    }
}
