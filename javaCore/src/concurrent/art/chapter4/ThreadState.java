package concurrent.art.chapter4;

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "YimeWating").start();

        new Thread(new Waiting(), "Waiting").start();
        //使用2个blocked线程一个获取成功一个获取失败
        new Thread(new Blocked(), "Blocked-01").start();

        new Thread(new Blocked(), "Blocked-02").start();
    }

    /**
     * 该线程一直在进行睡眠
     */
    static class TimeWaiting implements Runnable {

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
                SleepUtils.second(100);
            }
        }
    }

    /**
     * 线程在waiting实例上等待
     */
    static class Waiting implements Runnable {

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
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 该线程在blocked实例上加锁后不会释放锁
     */
    static class Blocked implements Runnable {

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
            synchronized (Blocked.class) {
                for (; ; ) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
