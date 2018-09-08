package com.springmvc.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IoClient {
    public static void main(String[] args){
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",8000);
            while (true){
                socket.getOutputStream().write((new Date()+" :hello world").getBytes());
                socket.getOutputStream().flush();
                Thread.sleep(2000);
            }
            } catch (IOException e) {

                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
