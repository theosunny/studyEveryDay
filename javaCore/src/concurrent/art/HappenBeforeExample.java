package concurrent.art;

public class HappenBeforeExample {
    static int i ;
    private static volatile int j;
    static HappenBeforeExample obj ;

    public HappenBeforeExample() {
        i=1;
        j=2;
    }

    public static void writer(){
        i=3;
        j=4;
        System.out.println(Thread.currentThread().getName()+"i="+i+"...j="+j);
    }

    public  static void reader(){
        System.out.println(Thread.currentThread().getName()+"i="+i+"...j="+j);


    }
public static void main(String[] args){
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            reader();
        }
    });
    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            writer();

        }
    });
    t1.setName("T1");

    t2.setName("T2");
    t2.start();
    t1.start();

}

}
