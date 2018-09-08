package com.test.duotai;




class A1 {
    public  void fun1(){
        System.err.println("A1++fun1");
    }
    public  void fun2(){
        System.err.println("A1++fun2");
    }

}
class B1 extends A1{
    public void fun1() {
        System.err.println("B1++fun1");
    }

    public void fun3() {
        System.err.println("B1++fun3");
    }
}
class C1 extends A1{
    public void fun1() {
        System.err.println("C1++fun1");
    }

    public void fun4() {
        System.err.println("C1++fun4");
    }
}





    /**
 * 实现一个设计，要求此方法可以接收A1类的任意子类对象，并且调用方法
 */
public class ClassDemo {
    public static void main(String[] args){
        fun(new B1());
        fun(new C1());
    }
    public static void fun(A1 a ){
        a.fun1();
        //在满足要求后。如果再想调用子类方法，则需要向下转型，但是为了防止这个子类不是父类的实例，则需要instanceof关键字来判断
        if (a instanceof  B1){
            B1 b = (B1)a;
            b.fun3();
        }
        if (a instanceof  C1){
            C1 c1c = (C1)a;
            c1c.fun4();
        }
    }
}
