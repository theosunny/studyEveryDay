package com.test.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 传统定时器
 */
public class TranditionalTimer {
public static void main(String[] args){
    //定时器10s启动爆炸
    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("--bombing--");
        }
    },10000);
    while (true){
        System.out.println(new Date().getSeconds());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //定时器10s启动爆炸
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-10s后3秒扎一次-bombing--");
            }
        },10000,3000);

    }
}
}
