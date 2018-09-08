package com.test.enumDemo;

public class TestEnum1 {
    public static void main(String[] args){
        Color c = Color.BALACK;
        System.err.println(c);
        for (Color c1: Color.values()
             ) {
            System.err.println(c1);
        }
    }
}
