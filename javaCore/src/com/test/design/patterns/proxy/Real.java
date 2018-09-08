package com.test.design.patterns.proxy;

public class Real implements NetWork{
    @Override
    public void browser() {
        System.err.println("实现上网");
    }
}
