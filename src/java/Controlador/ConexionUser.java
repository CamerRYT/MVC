/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author camer
 */
public class ConexionUser {
     public static Connection getConnection(){
        //establecer la conexion con la bd
        
        String url, user, pass;
        url = "jdbc:mysql://localhost/usuarios";
        user = "root";
        pass = "35182045";
        
        //establcer el objeto de conexion
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Si conecto a la bd");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("No conecto a la bd");
        }   
        return con;
    }
    
    
}
