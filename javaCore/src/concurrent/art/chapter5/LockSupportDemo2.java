package concurrent.art.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockSupportDemo2 {
    public static void main(String[] args) throws InterruptedException {
       final ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

      Lock lock =  rrw.readLock();
        Condition condition = lock.newCondition();
        lock.lock();
        condition.await();
        condition.notifyAll();
    }
}
