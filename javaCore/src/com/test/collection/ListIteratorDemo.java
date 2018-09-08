package com.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator主要是右前向后单向输出
 * ListIterator 双向输出，他是Iterator的子接口,只能通过list实例化，只能加载list中的内容
 */
public class ListIteratorDemo {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("_");
        list.add("2");
        list.add("4");
        list.add("的");
        list.add("243");
    ListIterator<String> listIterator = list.listIterator();  //实例化listiterator
        //由前向后输出
        System.err.println("由前向后输出");
        while (listIterator.hasNext()){
            System.err.print(listIterator.next()+"、");
        }
        System.err.print("\n");//备注：由后向前输出必须先由前向后输出，否则么有数据
        System.err.println("由后向前输出");//
        while (listIterator.hasPrevious()){
            System.err.print(listIterator.previous()+"、");
        }
    }
}
