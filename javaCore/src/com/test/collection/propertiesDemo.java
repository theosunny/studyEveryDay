package com.test.collection;

import java.io.*;
import java.util.Properties;

/**
 * 配置文件
 */
public class propertiesDemo {
    public static void main(String[] args){
        Properties prop = new Properties();
        prop.setProperty("name","zs");
        File file = new File("c:"+File.separator+"IOTest"+File.separator+"prop.properties");
        if (!file.exists()){
            new File("c:"+File.separator+"IOTest").mkdirs();
        }
        try {
            //存入文件
            prop.store(new FileOutputStream(file),"测试");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //从文件读取配置文件
        Properties loadprop = new Properties();
        try {
            loadprop.load(new FileInputStream(file));
            loadprop.list(System.out);
            System.err.println("name"+loadprop.getProperty("name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //存入xml
        try {
            File filexml = new File("c:"+File.separator+"IOTest"+File.separator+"prop.xml");
            prop.storeToXML(new FileOutputStream(filexml),"测试存储xml");
            //从文件读取配置文件
            loadprop.loadFromXML(new FileInputStream(filexml));
            loadprop.list(System.out);
            System.err.println("name"+loadprop.getProperty("name"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
