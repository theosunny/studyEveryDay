package chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 10-19
 */
public class ProcessData {
    private static final ReentrantReadWriteLock rwl       = new ReentrantReadWriteLock();
    private static final Lock                   readLock  = rwl.readLock();
    private static final Lock                   writeLock = rwl.writeLock();
    private static Condition condition =writeLock .newCondition();
    private volatile static boolean                    update    = false;
    static Object o1 =new Object();
    public static  void processData() {
        readLock.lock();


        if (!update) {
            // �������ͷŶ���
            readLock.unlock();

            // ��������д����ȡ����ʼ
            writeLock.lock();
//            try {
//                condition.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            long start =System.currentTimeMillis() ;

            System.out.println((System.currentTimeMillis()-start)/1000);

            try {
                System.out.println("++++++try++++++");
                if (!update) {
                    // ׼�����ݵ����̣��ԣ�
                    update = true;
                }
                readLock.lock();
            } finally {
                System.out.println("=====finally=====");

                writeLock.unlock();
            }
            // ��������ɣ�д������Ϊ����
        }
        System.out.println(update+"**********");
        try {
            System.out.println(Thread.currentThread().getName());
        } finally {
            readLock.unlock();
        }

    }
    public static void main(String[] args){
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LockSupport.park();
                    processData();
                }
            },"A"+(i+1));
            ts.add(thread);
        }



        ts.forEach(Thread::start);
        ts.stream().filter(thread -> !thread.getName().equals("A1")).forEach(LockSupport::unpark);
    }
}
