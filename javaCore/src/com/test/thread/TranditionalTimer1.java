package com.test.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 传统定时器
 * 2s,4s交替炸
 *
 */
public class TranditionalTimer1 {

private static int count = 0 ;
public static void main(String[] args){
    class myTimer extends TimerTask {

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            count =(count+1)%2;
            System.out.println("--bombing2--");
            new Timer().schedule(new myTimer(),2000+2000*count);
        }
    }
    //定时器10s启动爆炸
    new Timer().schedule(new myTimer(),2000);
    while (true){
        System.out.println(new Date().getSeconds());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}
