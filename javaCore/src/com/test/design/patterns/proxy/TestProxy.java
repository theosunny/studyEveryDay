package com.test.design.patterns.proxy;

public class TestProxy {
    public static void main(String[] args){
        NetWork netWork = null;
        netWork =  new Prox(new Real());
        netWork.browser();
    }
}
