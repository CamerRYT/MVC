/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author camer
 */
public class AccionesUsuario {
    //int position = 0;
    public static int registrarUsuario(User urs) throws SQLException{
        
        try {
            Connection con = Conexion.getConnection();//ya solo es la instancia
            String sq = "insert into usuario(username, pass) values (?,?)";
            
            //el cual es perparar la setencia
            PreparedStatement ps = con.prepareStatement(sq);
            
            //obtener cada uno de los elementos del objeto
            ps.setString(1, urs.getUsername());
            ps.setString(2, urs.getPass());
            
             //ejecuto la setencia
            ps.executeUpdate();
            System.out.println("Alumno registrado con exito");
            con.close();
        
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se pudo registrar el alumno");
        }
        return 0;
        
    }
   
}
