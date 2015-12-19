package Operaciones;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Eliminar {
    public static void eliminarPelicula(String id_pelicula) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "delete from catalogo where id= ('" + id_pelicula.toUpperCase() + "')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
       public static void eliminarCliente(String curp_cliente) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "delete from cliente where curp= ('" + curp_cliente.toUpperCase() + "')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
            public static void eliminarRegistroVenta(String numRenta) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "delete from registroventa where numeroderenta= ('" + numRenta + "')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
public static void eliminarSocio(String id_socio) {
        try {
           Conexion obj = new Conexion();
            obj.conectar();
            String sql = "delete from socio where id= ('" + id_socio.toUpperCase() + "')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }

public static void quitarpeliculas(String cantidadnueva,String cantidadvieja,String id_pelicula){
try {
            Conexion obj = new Conexion();
            obj.conectar();
            int y=Integer.parseInt(cantidadvieja)-Integer.parseInt(cantidadnueva);
            String nuevacantidad=String.valueOf(y);
            String sql = "update catalogo set disponibles='"+nuevacantidad+"' where id='"+id_pelicula+"'";
            System.out.println(sql);
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
public static void descontarpeliculas(String cantidad,String id_pelicula){
try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "update catalogo set disponibles='"+cantidad+"' where id='"+id_pelicula+"'";
            System.out.println(sql);
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
}
}