package concurrent.art.chapter4;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    static Object object = new Object();
    private static volatile  boolean flag = true;

    static class Wait implements Runnable{

        @Override
        public void run() {
           synchronized (object){

               while (flag){
                   System.out.println(Thread.currentThread()+"flag is true .wait"
                   + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                   try {
                       //调用wait方法会释放object对象的锁
                       object.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println(Thread.currentThread()+"flag is false .running"
                       + new SimpleDateFormat("HH:mm:ss").format(new Date()));
           }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            //加锁拥有object的监视
            synchronized (object){
                //获取object的锁，然后进行通知，通知时候不会释放锁
                //直到当前线程释放object后， Wait才从wait方法返回
                System.out.println(Thread.currentThread()+"hold lock notify "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                object.notifyAll();
                flag=false;
                SleepUtils.second(2);
            }
            synchronized (object){
                System.out.println(Thread.currentThread()+"hold lock again "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(3);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(2);
        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }
}
