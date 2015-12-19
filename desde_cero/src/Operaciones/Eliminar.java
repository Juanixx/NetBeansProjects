package Operaciones;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Eliminar {
    public static void eliminarPelicula(String id_pelicula) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "delete from pelicula where id_pelicula= ('" + id_pelicula + "')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
        public static void eliminarCliente(String id_cliente) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "delete from cliente where id_cliente= ('" + id_cliente + "')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
            public static void eliminarEncargado(String id_encargado) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "delete from encargado where id_encargado= ('" + id_encargado + "')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
public static void eliminarSocio(String id_socio) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "delete from socio where id_socio= ('" + id_socio + "')";
            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }

}
