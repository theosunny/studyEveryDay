package com.test.collection;

import java.util.LinkedList;

/**
 * LinkedList 链表操作接口，同时实现quenen 队列接口 先进先出。FIFO
 */

public class LinkListDemo1 {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.err.println(linkedList);
      /*  linkedList.addFirst("F");//开头添加
        linkedList.addLast("L");//结尾添加
        System.err.println("增加头尾之后的链表："+linkedList);

        System.err.println("linkedlist.element找到表头"+linkedList.element());
        System.err.println("找完之后的链表数据"+linkedList);
        System.err.println("linkedlist.peek找到表头"+linkedList.peek());//找到不删除链表的头
        System.err.println("找完之后的链表数据"+linkedList);
        System.err.println("linkedlist.poll找到表头"+linkedList.poll());//找到并且删除链表的头
        System.err.println("找完之后的链表数据"+linkedList);*/

        //以先进先出方式一个个打印结果
        for (int i = linkedList.size(); i >0; i--) {
            String element = linkedList.poll();
            System.err.println(element);
            System.err.println("size="+linkedList.size());
        }
    }
}
