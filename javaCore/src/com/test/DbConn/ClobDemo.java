package com.test.DbConn;

import java.io.*;
import java.sql.*;

/**
 * 处理大文本
 */
public class ClobDemo {

    private static  Connection connection=GetConnection.GetInstance();
    public static void main(String[] args){
//        insertClobdata();
//        readClobdata();
//        JDBc2ReadDemo();
//        JDBc2inserDemo();
//        JDBc20updateDemo();
        JDBc20BatchDemo();
    }


    /**
     * 插入图片信息
     */
    public  static void insertClobdata(){
        String sql ="insert into t_user(name,image) values(?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,"fanyy1");
//            C:\Users\Administrator\Pictures
            File f = new File("c://Users/Administrator/Pictures/IMG_0251.JPG");
            pst.setBinaryStream(2,new FileInputStream(f),(int)f.length());
            int flag = pst.executeUpdate();
            System.err.println("flag="+flag);
            if (flag>=0){
                System.err.println("新增成功");
            }else {
                System.err.println("新增失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取图片信息并且保存
     */
    public  static void readClobdata(){
        String sql ="select image from t_user where id =2 ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet set  =pst.executeQuery();
            File f = new File("c://Users/Administrator/Pictures/copy.jpg");
            while (set.next()){
//               InputStream fis =  set.getBinaryStream(1);
//                FileOutputStream fos = new FileOutputStream(f);
//                int temp =0 ;
//                while ((temp=fis.read())!=-1){
//                    fos.write(fis.read());//边读边写
//                }
//                fis.close();
//                fos.close();
//                System.out.println("读写成功");

                Blob b =set.getBlob(1);
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(b.getBytes(1,(int)b.length()));
                fos.close();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 可滚动的结果集
     */
    public static void JDBc2ReadDemo(){
        String sql ="select ID,name from t_user";
        ResultSet set = null;
        //设置结果集滚动，并且是只读的
        try {
            PreparedStatement pst = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            set=pst.executeQuery();
            System.err.println("取第3条数据");
            set.absolute(2);
            print(set,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void print(ResultSet rs,int len){

            try {
                if (len>0){
                    rs.next();
                }else {
                    rs.previous();
                }
                int id = rs.getInt(1);
                String name =rs.getString(2);
                System.out.println("id="+id+",name="+name);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    /**
     * 结果集插入数据
     */
    public static void JDBc2inserDemo(){
        String sql ="select ID,name from t_user";
        ResultSet set = null;
        //设置结果集滚动，并且是可更新的
        try {
            PreparedStatement pst = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            set=pst.executeQuery();
            //移动到可插入数据的行
            set.moveToInsertRow();
            set.updateString(2,"zs");
            set.insertRow();//插入数据
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 滚动结果集更新数据
     */
    public static void JDBc20updateDemo(){
        String sql ="select ID,name from t_user where name='zs'";
        ResultSet set = null;
        //设置结果集滚动，并且是可更新的
        try {
            PreparedStatement pst = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            set=pst.executeQuery();
            //移动到可插入数据的行
            set.last();//因为是单条记录，所以直接将指针移到最后
            set.updateString(2,"ls");
            set.updateRow();//g更新数据
//            set.deleteRow();删除当前行
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批处理
     */
    public static void JDBc20BatchDemo(){
        String sql = "insert t_user(name) values (?) " ;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                pst.setString(1,"fanyy"+i++);
                pst.addBatch();
            }
            int a[] =pst.executeBatch();
            System.out.println("新增了"+a.length+"条记录数");
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
