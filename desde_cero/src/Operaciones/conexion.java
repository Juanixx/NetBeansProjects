
package Operaciones;

import java.sql.*;
import javax.swing.*;

public class conexion {

    Statement stm;//permite realizar consultas sql
    Connection con;

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto_progrados", "postgres", "uriel");
            stm = con.createStatement();//permite ejecutar sentencias sql
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion.");
                    }
    }

    public ResultSet consultaFrom(String consulta) throws SQLException {
        ResultSet rs;
        rs = stm.executeQuery(consulta);//solo para select
                return rs;
    }

  public void realizarOperacion(String consulta) throws SQLException {
stm=con.createStatement();
stm.executeUpdate(consulta);
}

    public void cerrarConexion() throws SQLException {
        stm.execute("END");
        stm.close();
        con.close();

    }
}

