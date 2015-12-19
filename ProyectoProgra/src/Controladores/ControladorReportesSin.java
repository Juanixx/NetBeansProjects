package Controladores;
import Reportes.reportin;
import Vistas.ReportesSin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControladorReportesSin {
    ReportesSin ventana;
    reportin c=new reportin();
    public ControladorReportesSin(ReportesSin ventana){
    this.ventana=ventana;
    this.ventana.getContentPane().setBackground(Color.LIGHT_GRAY);
    this.ventana.setTitle("Reportes sin parámetros");
    cargarEscuchadores();
    this.ventana.setVisible(true);
    }
    private void cargarEscuchadores(){
    this.ventana.getBtn_ReporteSocio().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c.reporte("reporte1");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReportesSin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    this.ventana.getBtn_ReporteCliente().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c.reporte("reporte2");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReportesSin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    this.ventana.getBtn_ReporteCatalogo().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c.reporte("reporte3");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReportesSin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    this.ventana.getBtn_Cerrar().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    this.ventana.getBtn_RegistroRenta().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c.reporte("reporte4");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReportesSin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    this.ventana.getBtn_RegistroDevolucion().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c.reporte("reporte5");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReportesSin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    }
    }
