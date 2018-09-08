package concurrent.art;

public class FinaReferenceExample {
    int i ;
    private final int j;
    static  FinaReferenceExample obj ;

    public  FinaReferenceExample () {
        i=1;
        j=2;
    }

    public static void writer(){
        obj = new FinaReferenceExample();
    }

    public  static void reader(){
        FinaReferenceExample fs =  obj;
        int a = fs.i;
        int b=fs.j;
        System.out.println("a="+a+"b="+b);

    }
public static void main(String[] args){
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            writer();
        }
    });
  t1.isInterrupted();
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            reader();
        }
    });
    t1.start();
    t2.start();
}

}
