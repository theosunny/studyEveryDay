package concurrent.art.chapter4;

import java.util.concurrent.TimeUnit;

public class ThreadLocalProfiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long intialValue(){
          return System.currentTimeMillis();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws InterruptedException {
         ThreadLocalProfiler.begin();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("cost:"+ ThreadLocalProfiler.end());
    }
}
