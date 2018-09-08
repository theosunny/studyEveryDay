package concurrent.art.chapter5;

import java.util.concurrent.ArrayBlockingQueue;

public class Weiyi {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(-10 >> 3);
        System.out.println(1 << 1);
        System.out.println(2 ^ 1);
        System.out.println(0xffffcd7d);
        System.out.println(1 << 10);
        System.out.println(16 << 15);
        System.out.println(524288 / 16);
        System.out.println(Integer.parseInt("00001111", 2) & 15);
        System.out.println(Integer.parseInt("00011111", 2) & 15);
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(12);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.put("1");


        System.out.println(arrayBlockingQueue.size());
    }
}