/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Agregar {
 
     public static void agregarPelicula(String id_pelicula, String titulo,  String clasificacion, String id_socio) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "insert into pelicula(id_pelicula, titulo, clasificacion, id_socio) values ('" + id_pelicula + "','" + titulo + "','"+clasificacion+"','"+id_socio+"')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
     
     public static void agregarSocio( String id_socio, String nombre, String apellido, String telefono) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "insert into socio(id_socio, nombre, apellido, telefono) values ('" + id_socio + "','" + nombre + "','"+apellido+"','"+telefono+"')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
     
     public static void agregarCliente( String id_cliente, String nombre, String apellido, 
             String sexo, String fechadenacimiento, String telefono) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "insert into cliente(id_cliente, nombre, apellido, sexo, fechadenacimiento,"
                    + " telefono) values ('" + id_cliente + "','" + nombre + "','"+apellido+"','"+sexo+"'"
                    + ",'"+fechadenacimiento+"','"+telefono+"')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
        
    }
     
     public static void agregarEncargado( String id_encargado, String nombre, String apellido, 
             String imss, String fechadenacimiento, String telefono) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "insert into encargado(id_encargado, nombre, apellido, imss, fechadenacimiento,"
                    + " telefono) values ('" + id_encargado + "','" + nombre + "','"+apellido+"','"+imss+"'"
                    + ",'"+fechadenacimiento+"','"+telefono+"')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
}
