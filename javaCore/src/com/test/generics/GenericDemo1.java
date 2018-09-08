package com.test.generics;

public class GenericDemo1 {
    public static void main(String[] args) {
        Info<String> info = new Info();
        info.setVar("tt");
//         fun(info);//报错，所以得出，参数的类型要相同，即使string 是可以向上转型的
         fun1(info);

    }

    public static void  fun(Info<Object> info){
        System.err.println("info="+info);;
    }
    public static void  fun1(Info<?> info){//表示可以使用任意类型的对象
        System.err.println("info="+info);
    }

}
