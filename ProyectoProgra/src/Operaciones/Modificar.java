package Operaciones;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modificar {
   public static void modficarPelicula(String idanterior, String nuevotitulo, String nuevoid
            , String nuevaclasificacion,String costo, String disponibles, String nuevoid_socio) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "update catalogo set id='" + nuevoid.toUpperCase() + 
                    "',titulo='" + nuevotitulo.toUpperCase() + "',clasificacion='"+nuevaclasificacion.toUpperCase()+"',costorentapordia='"+costo+"',disponibles='"+disponibles+
                    "',id_socio='"+nuevoid_socio.toUpperCase()+"' where id='" + idanterior.toUpperCase() + "'";

            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    public static void modficarCliente(String curp_cliente, String nombre, String apellido, 
             String sexo, String direccion, String telefono) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
                 
            String sql = "update cliente set nombre='"+nombre.toUpperCase()+"',apellido='"+apellido.toUpperCase()+"',sexo='"+sexo.toUpperCase()+"',direccion='"+direccion.toUpperCase()+"',telefono='"+telefono+"'";
         
            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
   public static void modficarSocio(String idanterior, String nuevonombre, String nuevoid
            , String nuevoapellido,  String nuevotel) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
            String sql = "update socio set id='" + nuevoid.toUpperCase() + 
                    "',nombre='" + nuevonombre.toUpperCase() + "',apellido='"+nuevoapellido.toUpperCase()+
                    "',telefono='"+nuevotel+"'where id='" + idanterior.toUpperCase() + "'";

            obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public static void modficarRegistroVenta(String numrenta, String id_pelicula,String curp_cliente,String cantidad,String fecharenta,String fechadevolucion) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
String sql = "update registroventa set id_pelicula='" + id_pelicula.toUpperCase() + "',curp_cliente='" + curp_cliente.toUpperCase() + "',cantidad='" + cantidad.toUpperCase() + "',fecha_renta='" + fecharenta + "',fecha_devolucion='" + fechadevolucion + "' where numeroderenta='"+numrenta+"';";          
obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public static void modficarRegistroDevolucion(String numerodevolucion,String curp_cliente,String id_pelicula,String cantidad,String fechadevuelta,String recargo,String total) {
        try {
            Conexion obj = new Conexion();
            obj.conectar();
String sql = "update registrodevolucion set numerodedevolucion='" + numerodevolucion + "',curp_cliente='" + curp_cliente.toUpperCase() + "',id_pelicula='"+id_pelicula+"',cantidad='" + cantidad.toUpperCase() + "',fecha_deuelta='" + fechadevuelta + "',recargo='" + recargo + "',totalapagar='"+total+"' where numerodedevolucion='"+numerodevolucion+"';";          
obj.realizarOperacion(sql);
            obj.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    
}
