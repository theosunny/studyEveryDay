package com.future.javaImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RealData implements Callable<String>{
    private String para ;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
      return sb.toString();
    }
}
