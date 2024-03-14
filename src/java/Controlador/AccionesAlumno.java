/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author camer
 */
//vamos a registralo a elminar 
import java.sql.*;
//jalar la conexion con la bd
import Modelo.Alumno;
import java.util.ArrayList;
import java.util.List;

public class AccionesAlumno {
    //primero vamos a registrar al alumno
    
    public static int registrarAlumno(Alumno alu){
        int estatus = 0; //si se registro o no se registro
        
        try {
            //establexco la conexion
            Connection con = Conexion.getConnection();//ya solo es la instancia
            String q = "insert into alumno(nom_alu, appat_alu,"
                        + "apmat_alu, edad_alu) values (?,?,?,?)";;
            
            //el cual es perparar la setencia
            PreparedStatement ps = con.prepareStatement(q);
            
            //obtener cada uno de los elementos del objeto
            ps.setString(1, alu.getNom_alu());
            ps.setString(2, alu.getAppat_alu());
            ps.setString(3, alu.getApmat_alu());
            ps.setInt(4, alu.getEdad_alu());
            
            //ejecuto la setencia
            estatus = ps.executeUpdate();
            System.out.println("Alumno registrado con exito");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se pudo registrar el alumno");
        }
        return estatus;
    }
    //poder visualizar a todos los alumnos en lista
    public static List<Alumno> getAllAlumnos(){
        //genero mi objeto de lista de un arrayList
        List<Alumno> lista = new ArrayList<Alumno>();
        
        try {
            //primero la conexion 
            Connection con = Conexion.getConnection();
            String q = "select * from alumno";
            //preparo la sentencia 
            PreparedStatement ps = con.prepareStatement(q);
            //voy a utilizar el objeto para la consulta de los datos
            ResultSet rs = ps.executeQuery();
            
            //como no se utlizar datos ya exite en la tabla debo de obtenerlos
            while(rs.next()){
                //genero objeto tipo alumno
                Alumno alu = new Alumno();
                alu.setIdAlumno(rs.getInt(1));
                alu.setNom_alu(rs.getString(2));
                alu.setAppat_alu(rs.getString(3));
                alu.setApmat_alu(rs.getString(4));
                alu.setEdad_alu(rs.getInt(5));
                //los agrego a mi lista
                lista.add(alu);
            }
            System.out.println("Se hizo la consulta de alumno");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se encontra la tabla");
        }
        return lista;
    }
    
    //buscar un alumno por id
    public static Alumno buscarAlumnoById(int id){
        //necesito crear una instancia del alumno
        Alumno alu = new Alumno();
        try {
            Connection con = Conexion.getConnection();
            String q = "select * from alumno where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            //para la consults
            ResultSet rs = ps.executeQuery();
            //tengo que buscar dentro de la tabla 
            if(rs.next()){
                //get y set
                alu.setIdAlumno(rs.getInt(1));
                alu.setNom_alu(rs.getString(2));
                alu.setAppat_alu(rs.getString(3));
                alu.setApmat_alu(rs.getString(4));
                alu.setEdad_alu(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            System.out.println("No se encontro al alumno");
        }
        return alu; //porque ya no quiero a todos solo a uno
    }
    
    public static int actualizarAlumno(Alumno alu){
        int estatus = 0;
        
        try {
            Connection con = Conexion.getConnection();
            String q = "update alumno set nom_alu = ?, appat_alu = ?, apmat_alu = ?, edad_alu = ? "
                    + "where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, alu.getNom_alu());
            ps.setString(2, alu.getAppat_alu());
            ps.setString(3, alu.getApmat_alu());
            ps.setInt(4, alu.getEdad_alu());
            ps.setInt(5, alu.getIdAlumno());
            
            estatus = ps.executeUpdate();
            System.out.println("Se actualizo el alumno");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se pudo actualizar el alumno");
        }
        return estatus;
    
    }
    
    public static int eliminarAlumno(int id){
        int estatus = 0;
        
        try {
            Connection con = Conexion.getConnection();
            String q = "delete from alumno where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);//lo preparo
            estatus = ps.executeUpdate();//ejecute la actualizacion 
            System.out.println("Se elimno al alumno de la lista");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se elimino al alumno");
        }
        return estatus;
    }
    
}
