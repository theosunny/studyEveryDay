package concurrent.art.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    private static Thread mainThread;

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+" start ta");
        ta.start();
        try {
            ta.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" block");
        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(Thread.currentThread().getName()+" continue");
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+" wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
        }
    }
}
