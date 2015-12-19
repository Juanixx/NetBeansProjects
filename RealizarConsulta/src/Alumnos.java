
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Alumnos {

    public static void agregarPersona(String nombre, String Edad) {
        try{
        RealizarConsulta obj=new RealizarConsulta();
        obj.conectar();
        int edad=Integer.parseInt(Edad);
        String sql="insert into AlumnosProgra(nombre, edad) values ('"+nombre+"','"+edad+"')";
        obj.realizarOperacion(sql);
        obj.desconectar();
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    public static void eliminarPersona(String nombre) {
        try{            
            String a="'"+nombre+"'";
            nombre=a;
        RealizarConsulta obj=new RealizarConsulta();
        obj.conectar();
        String sql="delete from AlumnosProgra where nombre="+nombre;
        obj.realizarOperacion(sql);
        obj.desconectar();
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
}
    public static ResultSet Consulta() throws SQLException{
    RealizarConsulta obj=new RealizarConsulta();
        obj.conectar();
        String sql="select * from AlumnosProgra";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }
    public static void Modificar(String NombreViejo,String NombreNuevo,int edad){
try{            
        
        RealizarConsulta obj=new RealizarConsulta();
        obj.conectar();
        String sql="Update Itspa.AlumnosProgra set nombre='"+NombreNuevo+"',edad="+edad+" where nombre='"+NombreViejo+"'";
        obj.realizarOperacion(sql);
        obj.desconectar();
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }

    
    }
    
}