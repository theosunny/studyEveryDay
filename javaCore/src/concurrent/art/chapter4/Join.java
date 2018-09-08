package concurrent.art.chapter4;

import java.util.concurrent.TimeUnit;

public class Join {
static class Domino implements Runnable{
    private Thread thread ;
    public Domino(Thread thread){
        this.thread=thread;
    }
    @Override
    public void run() {
        try {

            thread.join();
            while (true){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" terminated.");
    }
}
public static void main(String[] args) throws InterruptedException {
    Thread previous = new Thread();
    previous.setName("previous");
    for (int i = 0; i < 10; i++) {
        //每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
        Thread t = new Thread(new Domino(previous),"线程"+String.valueOf(i));
        t.start();
        previous=t;

    }
    previous.join();
    try {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminated ");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
