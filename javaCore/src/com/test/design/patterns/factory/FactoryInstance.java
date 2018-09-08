package com.test.design.patterns.factory;



public class FactoryInstance {

    public static Fruit GetInstanceFactory(String classname){
        Fruit f = null;
        if ("apple".equals(classname)) {
            f = new Apple();
        }
        if ("orange".equals(classname)){
            f=new Orange();
        }
        return f;
    }
}
