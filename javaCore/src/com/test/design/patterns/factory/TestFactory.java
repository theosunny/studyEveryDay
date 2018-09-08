package com.test.design.patterns.factory;

public class TestFactory {
    public static void main(String[] args){
        Fruit f = null;
       f= FactoryInstance.GetInstanceFactory("apple");
       f.eat();
    }
}
