package com.example.ApiJava.controllers; 
 
import java.sql.Connection;  
import java.sql.DriverManager;  
 
public class ConnectionMySQL{  
 
    public static Connection con_mysql;  
 
    public static Connection conectar(String host, String user, String password, String db) throws Exception  {  
            String databaseURL = "jdbc:mysql://" + host + "/" + db;  
            Class.forName("com.mysql.jdbc.Driver");  
            con_mysql = DriverManager.getConnection(databaseURL, user, password);  
        return con_mysql;  
    }  
 
}


/*
 * package com.example.ApiJava.controllers; 
 
import java.sql.Connection;  
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;  
 
public class ConnectionMySQL{  

    @Value("${spring.datasource.url}")
    static String databaseURL;

    @Value("${spring.datasource.username}")
    static String user;

    @Value("${spring.datasource.password}")
    static String password;
 
    public static Connection con_mysql;  
 
    public static Connection conectar(String host, String user, String password, String db) throws Exception  {  
            //String databaseURL = "jdbc:mysql://" + host + "/" + db;  
            Class.forName("com.mysql.jdbc.Driver");  
            con_mysql = DriverManager.getConnection(databaseURL, user, password);  
        return con_mysql;  
    }  
 
}
 */