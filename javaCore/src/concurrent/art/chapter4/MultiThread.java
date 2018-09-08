package concurrent.art.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args){
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        ThreadInfo[] tis = tmb.dumpAllThreads(false,false);
        for (ThreadInfo ti : tis) {
            System.out.println(ti.getThreadName());
        }
    }
}
