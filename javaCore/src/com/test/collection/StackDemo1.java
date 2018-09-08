package com.test.collection;

import java.util.Stack;

/**
 * 栈测试。
 * 栈是先进后出，比如网页浏览的返回键，就是栈的运用
 * stack是vector的子类
 */
public class StackDemo1 {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.err.println("stack = "+stack);
        System.err.println("c查询位置："+stack.search("A")); //A因为先进去，则最后出来
        String s = stack.peek();
        System.err.println("查出栈但是不删除"+s);
        System.err.println("stack = "+stack);
        System.err.println("查出栈并且删除"+stack.pop());
        System.err.println("stack = "+stack);
    }
}
