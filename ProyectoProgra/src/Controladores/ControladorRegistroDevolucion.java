/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;
import Operaciones.Validaciones;
import Operaciones.Agregar;
import Operaciones.Conexion;
import Operaciones.Modificar;
import Vistas.RegistroDevolucion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorRegistroDevolucion {

    RegistroDevolucion ventana;
Validaciones x=new Validaciones();
    public ControladorRegistroDevolucion(RegistroDevolucion ventana) {
        this.ventana = ventana;
        this.ventana.getContentPane().setBackground(Color.BLUE);
        this.ventana.setTitle("Registro de evoluciones");
        cargarEscuchadores();
        IniciaTabla();
        this.ventana.setVisible(true);
    }

    private void IniciaTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero de devolucion");
        modelo.addColumn("Curp Cliente");
        modelo.addColumn("ID Pelicula");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha devuelta");
        modelo.addColumn("Recargo");
        modelo.addColumn("Total");
        this.ventana.getTablaDevoluciones().setModel(modelo);
        String[] mios = new String[7];
        ResultSet dos;
        try {
            dos = Consulta();
            
            while (dos.next()) {
                mios[0] = dos.getString(1);
                mios[1] = dos.getString(2);
                mios[2] = dos.getString(3);
                mios[3] = dos.getString(4);
                mios[4] = dos.getString(5);
                mios[5] = dos.getString(6);
                mios[6] = dos.getString(7);
                modelo.addRow(mios);
            }
            this.ventana.getTablaDevoluciones().setModel(modelo);
            
        } catch (SQLException ex) {
            
        }
    }
    
    private void cargarEscuchadores() {
        this.ventana.getBtn_AgregarDevolucion().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregaDevolucion();
            }
        });
        this.ventana.getBtn_ActualizarDevolucion().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaDevolucion();
            }
        });
        this.ventana.getBtn_CerrarDevoluciones().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Cierra();
            }
        });
        this.ventana.getTablaDevoluciones().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MouseEvent t = e;
                ObtenRenglon(t);
            }
        });
        this.ventana.getBtn_LimpiarDevoluciones().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                LimpiaDatos();
            }
        });
        
        this.ventana.getTxt_IdPelicula().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetrasYDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras y números nadamás");
                
            }
            
        }

   });
        
        this.ventana.getTxt_Cantidad().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números nadamás");
                
            }
            
        }

   });
        
    }

    private void Cierra() {
        this.ventana.setVisible(false);
    }

    private void ObtenRenglon(MouseEvent e) {
        ArrayList<String> a = new ArrayList<>();
        for (int x = 0; x < 7; x++) {
            Object c = null;
            c = this.ventana.getTablaDevoluciones().getValueAt(this.ventana.getTablaDevoluciones().getSelectedRow(), x);
            a.add(c.toString());
            System.out.println(c.toString());
        }
        this.ventana.getTxt_NumerDeDevolucion().setText(a.get(0));
        this.ventana.getTxt_CurpCliente().setText(a.get(1));
        this.ventana.getTxt_IdPelicula().setText(a.get(2));
        this.ventana.getTxt_Cantidad().setText(a.get(3));
        this.ventana.getTxt_FechaDevuelta().setText(a.get(4));
        this.ventana.getTxt_Recargo().setText(a.get(5));
        this.ventana.getTxt_TotalAPagar().setText(a.get(6));
        
    }
    
    private void AgregaDevolucion() {
        if(x.ValidaFecha(this.ventana.getTxt_FechaDevuelta().getText())==false){
        JOptionPane.showMessageDialog(null, "Introduzca bien la fecha a devolver la película");
        }
        else{
        Agregar.agregarRegistroDevolucion(this.ventana.getTxt_CurpCliente().getText(), this.ventana.getTxt_IdPelicula().getText(), this.ventana.getTxt_Cantidad().getText(), this.ventana.getTxt_FechaDevuelta().getText(), this.ventana.getTxt_Recargo().getText(), this.ventana.getTxt_TotalAPagar().getText());
        }
            
        IniciaTabla();
    }
    
    private void ModificaDevolucion() {
        Modificar.modficarRegistroDevolucion(this.ventana.getTxt_NumerDeDevolucion().getText(), this.ventana.getTxt_CurpCliente().getText(), this.ventana.getTxt_IdPelicula().getText(), this.ventana.getTxt_Cantidad().getText(), this.ventana.getTxt_FechaDevuelta().getText(), this.ventana.getTxt_Recargo().getText(), this.ventana.getTxt_TotalAPagar().getText());
        IniciaTabla();
    }
    
    private ResultSet Consulta() throws SQLException {
        Conexion obj = new Conexion();
        obj.conectar();
        String sql = "select * from registrodevolucion";
        ResultSet uno = obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }

    private void LimpiaDatos() {
        this.ventana.getTxt_NumerDeDevolucion().setText("");
        this.ventana.getTxt_CurpCliente().setText("");
        this.ventana.getTxt_IdPelicula().setText("");
        this.ventana.getTxt_Cantidad().setText("");
        this.ventana.getTxt_FechaDevuelta().setText("");
        this.ventana.getTxt_Recargo().setText("");
        this.ventana.getTxt_TotalAPagar().setText("");
    }
}
