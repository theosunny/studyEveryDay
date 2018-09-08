package com.test.design.patterns.adapter;

public abstract  class Adapter implements  Window {
    public  void open(){}; //代开窗户 //覆写方法
    public  void close(){};//关窗户
    public  void wash(){};//系窗户、
    public  void destroy(){};//砸坏窗户
}
