package concurrent.art.chapter8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeDemo {
    private  static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadpool = Executors.newFixedThreadPool(2);
    public static void main(String[] args){
        threadpool.submit(new Runnable() {
            @Override
            public void run() {
                        String a = "银行流水A";
                try {
                   String b=exgr.exchange(a);
                    System.out.println("A和b的数据是否是一样的:"+a.equals(b));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadpool.submit(new Runnable() {
            @Override
            public void run() {
                String b = "银行流水A";
                try {
                   exgr.exchange(b);
//                    System.out.println("A和b的数据是否是一样的:"+a.equals(b));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
