package com.example.ApiJava.controllers;
 
import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Types;  
 
public class SampleStoredProcedures {  
 
    

    public static void ejecutar() throws SQLException {
        Connection conn = null;  
        try {  
            // Creamos la conexion  
            conn=ConnectionMySQL.conectar("localhost", "root", "", "springboot");  
            conn.setAutoCommit(false);  
 
             CallableStatement cStmt = conn.prepareCall("{call sp_get_categorias()}");    
             //cStmt.setString(1, "abcdefg");    
             //cStmt.setInt(2, 0);  
             cStmt.registerOutParameter("inOutParam", Types.INTEGER);    
 
             cStmt.execute();    
             final ResultSet rs = cStmt.getResultSet();  
 
             while (rs.next()) {  
                 System.out.println("Cadena de caracteres pasada como parametro de entrada="+rs.getString("inputParam"));  
             }    
 
             int outputValue = cStmt.getInt("inOutParam");  
             System.out.println("Parametro de salida incrementado="+outputValue);  
 
        }catch (Exception e) {  
            conn.rollback();  
            e.printStackTrace();  
        }finally{  
            conn.close();  
        }  
    }  
} 