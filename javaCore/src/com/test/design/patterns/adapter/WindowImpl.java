package com.test.design.patterns.adapter;

public class WindowImpl extends Adapter {
    @Override
    public void open() {
        System.err.println("打开窗户；");
    }

    @Override
    public void close() {
        System.err.println("关闭窗户；");
    }
}
