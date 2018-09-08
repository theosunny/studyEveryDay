package com.test.generics;

/**
 * 泛型的上限(extends)和下限(super)
 */
public class GenericDemo2 {
    public static void main(String[] args) {
        Info<String> info = new Info();
        info.setVar("tt");
         //fun(info);//报错，因为设置上限则必须是本类及其子类
        Info<Integer>  in = new Info<>();
        fun(in);
//        fun1(in);/报错，设置下限则必须是本类及其父类
        Info<Number>/***info<Object></>*/  in1 = new Info<>();
        fun(in1);
    }

    /**
     *
     * 泛型的上限，表示只能接收类型只能是数字比如，byte,short,long.doble int,float,也可以直接在Info类里面设置 info<? extends Number>
     * 如果是string就会报错。
     * @param info
     */
    public static void  fun(Info<? extends Number> info){//表示可以使用任意类型的对象
        System.err.println("info="+info);
    }

    /**
     *
     * 泛型的下限，只能在本类及其父类使用
     * 表示只能接收类型只能是数字比如，byte,short,long.doble int,float,
     * 如果是string就会报错。
     * @param info
     */
    public static void  fun1(Info<? super Number> info){//表示可以使用任意类型的对象
        System.err.println("info="+info);
    }


}
