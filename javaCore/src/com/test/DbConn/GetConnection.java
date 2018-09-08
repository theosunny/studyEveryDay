package com.test.DbConn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
private  static final  String DRIVER ="org.gjt.mm.mysql.Driver" ;
private static final String URL="jdbc:mysql://localhost:3306/ex";
private static final String user="fanyy";
private static final String password="fanyy";
public  static Connection connection;
private GetConnection(){}
public  static Connection GetInstance(){
    try {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,user,password);

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}

}
