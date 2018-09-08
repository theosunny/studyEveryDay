package concurrent.art.chapter5;

import java.util.concurrent.locks.LockSupport;

public class locksuportDemo3 {
 static void yt(){
     System.out.println("子线程 -> 测试通行许可！");
     LockSupport.park();
     System.out.println("子线程 -> 已通行！");
 }
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                yt();
            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                yt();
            }
        };
        thread.start();
        thread1.start();

        System.out.println("主线程 -> 休眠1秒！");

        System.out.println("主线程 -> 发放通行许可于子线程！");
        LockSupport.unpark(thread);
        LockSupport.unpark(thread1);

    /*
        运行结果：
        主线程 -> 休眠1秒！
        子线程 -> 测试通行许可！
        主线程 -> 发放通行许可于子线程！
        子线程 -> 已通行！
     */
    }
}