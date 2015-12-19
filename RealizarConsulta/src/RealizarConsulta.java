import java.sql.*;
public class RealizarConsulta {
static String bd = "Itspa";
static String login = "root";
static String password = "juan";
static String url = "jdbc:mysql://localhost/"+bd;
Connection conn = null;
Statement stm = null;
/** Constructor de DbConnection */
public void conectar() {
try{
//obtenemos el driver de para mysql
Class.forName("com.mysql.jdbc.Driver");
//obtenemos la conexión
conn = DriverManager.getConnection(url,login,password);
stm=conn.createStatement();
if (conn!=null){
System.out.println("Conexión a base de datos "+bd+". listo");
}
}catch( SQLException | ClassNotFoundException e){
System.out.println(e);
}
}
/*Permite hacer sentencias SELECT */
public ResultSet realizarConsulta(String consulta) throws SQLException {
ResultSet rs;
rs = stm.executeQuery(consulta);
return rs;
}
/*Permite realizar operación de */
public void realizarOperacion(String consulta) throws SQLException {
stm=conn.createStatement();
stm.executeUpdate(consulta);
}
/* Permite retornar la conexión */
public Connection getConnection(){
return conn;
}
/* termina la conexion a la base de datos */
public void desconectar(){
conn = null;
stm = null;
System.out.println("La conexion a la base de datos "+bd+" a terminado");
}}