package com.guardedSuspension;

public class App {
    public static void main(String[] args){
        RequestQueue q = new RequestQueue();
        for (int i = 0; i < 10; i++) {
            new ServerThread(q,"Sthread"+i).start();
        }
        for (int i = 0; i < 10; i++) {
            new ClientThread(q,"Sthread"+i).start();
        }
}
}
