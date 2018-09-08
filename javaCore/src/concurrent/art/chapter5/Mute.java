package concurrent.art.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 定义同一时刻只有一个线程占用锁
 */
public class Mute implements Lock {
    private  static  class  Sync extends AbstractQueuedSynchronizer{
        protected Sync() {
            super();
        }

        /**
         * 当状态为0的时候获取suo
         * @param acquires
         * @return
         */
        @Override
        protected boolean tryAcquire(int acquires) {
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return  true;
            }
            return  false;
        }

        /**
         * 释放锁将状态设置为0
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
             if (getState()==0) throw  new IllegalMonitorStateException();
             setExclusiveOwnerThread(null);
             setState(0);
             return true;
        }

        /**
         *
         * @param arg
         * @return
         */
        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        /**
         * 是否处于占用状态
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        Condition condition(){
            return new ConditionObject();
        }
    }

private final  Sync sync = new Sync();
    @Override
    public void lock() {
    sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.condition();
    }

    public  boolean isLocked(){
        return  sync.isHeldExclusively();
    }
}
