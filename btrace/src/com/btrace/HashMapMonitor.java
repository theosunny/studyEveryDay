package com.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class HashMapMonitor {

    // private static int callCount = 0;
    private static long time;
    private static long time0;

    @OnMethod(clazz = "java.util.concurrent.ConcurrentHashMap", method = "put", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void startPutOfConcurrentHashMap() {
        time = BTraceUtils.timeNanos();
    }

    @OnMethod(clazz = "java.util.concurrent.ConcurrentHashMap", method = "put", location = @Location(value = Kind.RETURN, clazz = "/.*/", method = "/.*/"))
    public static void endPutOfConcurrentHashMap() {
        long time1 = BTraceUtils.timeNanos();
        BTraceUtils.println(BTraceUtils.Strings.concat("ConcurrentHashMap:", BTraceUtils.str(time1 - time)));
    }

    @OnMethod(clazz = "java.util.HashMap", method = "put", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void startPutOfHashMap() {
        time0 = BTraceUtils.timeNanos();
    }

    @OnMethod(clazz = "java.util.HashMap", method = "put", location = @Location(value = Kind.RETURN, clazz = "/.*/", method = "/.*/"))
    public static void endPutOfHashMap() {
        long time1 = BTraceUtils.timeNanos();

        BTraceUtils.println(BTraceUtils.Strings.concat("HashMap:", BTraceUtils.str(time1 - time0)));
    }

}