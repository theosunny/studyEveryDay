package com.test.duotai;

public class B extends A{
    public void fun2(){
        System.err.println("B中的fun2");
    }

    @Override
    public void fun1() {
        System.out.println("B中的fun1");
    }

    public static void main(String[] args){
           //向上转型
        A a  = new B();
        a.fun1();  //向上转型只能调用父类有的子类方法
        System.err.println("--------向下转型-----------");
        B b = (B) a;
        b.fun1();
        b.fun2(); //向下转型可以调用子类的任何方法
    }
}
