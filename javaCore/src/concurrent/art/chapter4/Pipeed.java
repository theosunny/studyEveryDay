package concurrent.art.chapter4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入输出流
 */
public class Pipeed {

    public static void main(String[] args) throws IOException {
        PipedWriter out =new PipedWriter();
        PipedReader in = new PipedReader();
        //连接输入流和输出流
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"printThread");
        printThread.start();
        int receive = 0 ;
        System.out.println("开始你的表演：");
        while ((receive=System.in.read())!=-1){
            out.write(receive);
        }
    }

static class Print implements Runnable{
    private PipedReader in ;

    public Print(PipedReader in) {
         this.in=in;
    }

    @Override
    public void run() {
        int receive = 0 ;
        try {
            while ((receive=in.read())!=-1){
                System.out.print((char)receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } {

        }
    }
}
}
