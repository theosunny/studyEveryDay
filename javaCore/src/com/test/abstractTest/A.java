package com.test.abstractTest;

public abstract class A {
    private String name = "fanyy" ;
    public static final  String FLAG = "CHINA";
    public abstract  void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
