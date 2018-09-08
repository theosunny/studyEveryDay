package com.test.generics;

public class Info <T> {
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    private  T var ;

    @Override
    public String toString() {
        return "Info{" +
                "var=" + var +
                '}';
    }
}
