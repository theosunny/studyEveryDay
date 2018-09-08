package com.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class HelloWorld {
    @OnMethod(clazz = "java.lang.Thread",method="start")
    public static void onThreadStart() {
        BTraceUtils.println("Thread starts");
    }
}
