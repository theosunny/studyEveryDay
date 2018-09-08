package com.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

@BTrace
public class BtraceDemo {
    @OnMethod(clazz = "+cn")
    public static  void ondetail(@Self Object self, int id, @Return AnyType val){
        BTraceUtils.println("self="+self+",id="+id+",val="+val);
        BTraceUtils.println();
    }
    public static void onDetail(@Self Object self,AnyType[] args,@Return AnyType val){
        BTraceUtils.println("val="+val);
        BTraceUtils.println(); //must add println()，otherwise can not print the last record
    }
}
