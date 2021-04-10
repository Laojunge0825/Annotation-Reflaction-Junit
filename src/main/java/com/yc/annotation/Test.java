package com.yc.annotation;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: ReflactionAndAnotation
 * @author: 作者
 * @create: 2021-03-30 18:55
 */
@DBConnection( url = "jdbc:mysql://localhost:3306/test",driverClass = "com.mysql.jdbc.Driver")
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class c=Test.class;

       Annotation[ ] ans= c.getDeclaredAnnotations();
       DBConnection dbc= (DBConnection) c.getDeclaredAnnotation(DBConnection.class);
         String driverClass =dbc.driverClass();
         String url=dbc.url();
         String user=dbc.user();
         String password =dbc.password();

         Class.forName(driverClass);
        Connection conn= DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }
}
