package concurrent.art.chapter4.simpleConnectDemo;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数量
        int threadcount = 20 ;
        end = new CountDownLatch(threadcount);
        int count = 20 ;

        AtomicInteger got = new AtomicInteger();
        AtomicInteger nogot = new AtomicInteger();
        for (int i = 0; i < threadcount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,nogot),"ConnectionRunner");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke" + threadcount*count);
        System.out.println("got connection "+got);
        System.out.println("no got conncetion " +nogot);
    }

    static class ConnectionRunner implements Runnable {


        AtomicInteger got;
        int count = 0;
        AtomicInteger nogot;

        public ConnectionRunner( int count,AtomicInteger got, AtomicInteger nogot) {
            this.got = got;
            this.count = count;
            this.nogot = nogot;
        }


        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.relaseConnection(connection);
                            got.incrementAndGet();
                        }

                    }else {
                        nogot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
