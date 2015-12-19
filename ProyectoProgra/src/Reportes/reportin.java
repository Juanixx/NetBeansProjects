package Reportes;

import Operaciones.Conexion;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class reportin {
    //se estable una conexion con la base de datos 
    private Conexion con = new Conexion();
    /* reporte sencillo con conexion a base de datos MySQL,
     * el reporte no cuenta con parametros */
    
    public void reporte(String x) throws SQLException{ 
        JasperReport reporte;
    JasperPrint reporte_view; 
try{
    //----------------------------------- //direccion del archivo JASPER si ya lo tienen del iReport
   con.conectar();
   JasperReport report = JasperCompileManager.compileReport(getClass().getResource(x+".jrxml").getPath());
    URL in = this.getClass().getResource(x+".jasper");
   reporte = (JasperReport) JRLoader.loadObject(in);
    reporte_view= JasperFillManager.fillReport( report, new HashMap(),con.getConnection());
    
    JasperViewer jviewer = new JasperViewer(reporte_view,false); 
    
    jviewer.setTitle("Sistema de gestión de socios"); 
    jviewer.setVisible(true); 
    //terminamos la conexion a la base de datos
    con.desconectar();
}catch (JRException E){
    System.out.println(E.getMessage());
}
}
}

