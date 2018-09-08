package chapter05;

import java.io.FileInputStream;

public class TryCatchfinally {
    public static void main(String[] args) {
        TryCatchfinally m = new TryCatchfinally();

        System.out.println(m.amethod());
    }

    public int amethod() {
        try {
            // 1，抛出异常
            FileInputStream dis = new FileInputStream("test1.txt");
            System.out.println(11);
            return 1;
        } catch (Exception ex) {
            // 2.catch捕获异常，并执行
            System.out.println("No such file found");
            // 4,return 返回
            return -1;
        } finally {
            // 3.finally一定会在return之前执行。（准确说，应该是return;语句）
            System.out.println("Done finally");
        }
//        return 0;
    }
}