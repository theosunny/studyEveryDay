package com.test.abstractTest;

public class B extends A {

    @Override
    public void print() {
        System.err.println("test这是一个abstract类测试" + super.getName() + super.FLAG);

    }
   public static void main(String[] args){
       new B().print();
   }
}
