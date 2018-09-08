package concurrent.art.chapter4;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args)  {
        Thread sleepRunner =  new Thread(new SleepRunner(), "sleepRunner") ;
        sleepRunner.setDaemon(true);

        Thread busyRunner =   new Thread(new BusyRunner(), "BusyRunner");
        busyRunner.setDaemon(true);
        sleepRunner.start();


        busyRunner.start();
        //休眠5s让2个线程充分运行
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.err.println("0000"+e.getMessage());
        }


        try {
            sleepRunner.interrupt();
//            System.out.println("sleepRunner interrupted:"+sleepRunner.isInterrupted());
        }catch (Exception e){
            System.err.println("1111"+e.getMessage());
        }
        try {
            busyRunner.interrupt();
//            System.out.println("busyRunner interrupted:"+busyRunner.isInterrupted());
        }catch (Exception e){
            System.err.println("www"+e.getMessage());
        }



        //防止2个线程立刻退出
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 该线程一直在进行睡眠
     */
    static class BusyRunner implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    /**
     * 线程在waiting实例上等待
     */
    static class SleepRunner implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while (true) {
              SleepUtils.second(10);
            }
        }
    }


}
