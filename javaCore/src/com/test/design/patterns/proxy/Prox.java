package com.test.design.patterns.proxy;

public class Prox implements NetWork{
    public  NetWork netWork;

    public Prox(NetWork netWork) {//设置真实的操作/
        this.netWork = netWork;//设置代理的子类
    }
    public void browser(){
        check();
        this.netWork.browser();
    }
    public void check(){
        System.err.println("检查用户是否正确");
    }
}