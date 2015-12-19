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
 
     public static void agregarPelicula(String id_pelicula, String titulo,  String clasificacion,String costo, String disponibles, String id_socio) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "insert into catalogo(id, titulo, clasificacion,costorentapordia,disponibles, id_socio) values ('" + id_pelicula.toUpperCase() + "','" + titulo.toUpperCase() + "','"+clasificacion.toUpperCase()+"','"+costo+"','"+disponibles+"','"+id_socio.toUpperCase()+"')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }
     
     public static void agregarSocio( String id_socio, String nombre, String apellido, String telefono) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "insert into socio(id, nombre, apellido, telefono) values ('" + id_socio.toUpperCase() + "','" + nombre.toUpperCase() + "','"+apellido.toUpperCase()+"','"+telefono+"')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
     
     public static void agregarCliente( String curp_cliente, String nombre, String apellido, 
             String sexo, String direccion, String telefono) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "insert into cliente(curp,nombre,apellido,sexo,direccion,telefono) VALUES('"+curp_cliente.toUpperCase()+"','"+nombre.toUpperCase()+"','"+apellido.toUpperCase()+"','"+sexo.toUpperCase()+"','"+direccion.toUpperCase()+"','"+telefono+"')";

            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
        
    }
     
    public static void agregarRegistroVenta(String id_pelicula,String curp_cliente,String cantidad,String fecharenta,String fechadevolucion) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "insert into registroventa(numeroderenta,id_pelicula,curp_cliente,cantidad,fecha_renta,fecha_devolucion) values (null,'" + id_pelicula.toUpperCase() + "','" + curp_cliente.toUpperCase() + "','"+cantidad+"','" + fecharenta + "','" + fechadevolucion + "')";
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    public static void agregarRegistroDevolucion(String curp_cliente,String id_pelicula,String cantidad,String fechadevuelta,String recargo,String total) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "insert into registrodevolucion(numerodedevolucion,curp_cliente,id_pelicula,cantidad,fecha_deuelta,recargo,totalapagar) values (null,'" + curp_cliente.toUpperCase() + "','" + id_pelicula.toUpperCase() + "','"+cantidad+"','" + fechadevuelta + "','" + recargo + "','"+total+"')";
            System.out.println(sql);
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    public static void AgregarCantidadAPelicula(String cantidadnueva,String cantidadvieja,String id_pelicula ){
    try {
            Conexion obj = new Conexion();
            obj.conectar();
            int y=Integer.parseInt(cantidadnueva)+Integer.parseInt(cantidadvieja);
            String nuevacantidad=String.valueOf(y);
            System.out.println("yyyyy   "+nuevacantidad);
            String sql = "update catalogo set disponibles='"+nuevacantidad+"' where id='"+id_pelicula+"'";
            System.out.println(sql);
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
public static void AgregaCantidad(String cantidad,String id_pelicula){
String sql = "update catalogo set disponibles='"+cantidad+"' where id='"+id_pelicula+"'";
}
    }
