package Operaciones;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modificar {
    public static void modficarPelicula(String idanterior, String nuevotitulo, String nuevoid
            , String nuevaclasificacion, String nuevoid_socio) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "update pelicula set id_pelicula='" + nuevoid + 
                    "',titulo='" + nuevotitulo + "',clasificacion='"+nuevaclasificacion+
                    "',id_socio='"+nuevoid_socio+"'where id_pelicula='" + idanterior + "'";

            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    public static void modficarCliente(String idanterior, String nuevonombre, String nuevoid
            , String nuevoapellido, String nuevosexo, String nuevafecha, String nuevotel) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "update cliente set id_cliente='" + nuevoid + 
                    "',nombre='" + nuevonombre + "',apellido='"+nuevoapellido+
                    "',sexo='"+nuevosexo+"',fechadenacimiento='"+nuevafecha+
                    "',telefono='"+nuevotel+"'where id_cliente='" + idanterior + "'";

            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    public static void modficarSocio(String idanterior, String nuevonombre, String nuevoid
            , String nuevoapellido,  String nuevotel) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "update socio set id_socio='" + nuevoid + 
                    "',nombre='" + nuevonombre + "',apellido='"+nuevoapellido+
                    "',telefono='"+nuevotel+"'where id_socio='" + idanterior + "'";

            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public static void modficarEncargado(String idanterior, String nuevonombre, String nuevoid
            , String nuevoapellido, String nuevoimss, String nuevafecha, String nuevotel) {
        try {
            conexion obj = new conexion();
            obj.conectar();
            String sql = "update encargado set id_encargado='" + nuevoid + 
                    "',nombre='" + nuevonombre + "',apellido='"+nuevoapellido+
                    "',imss='"+nuevoimss+"',fechadenacimiento='"+nuevafecha+
                    "',telefono='"+nuevotel+"'where id_encargado='" + idanterior + "'";

            obj.realizarOperacion(sql);
            obj.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    
}
