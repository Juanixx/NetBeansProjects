package Controladores;
import Operaciones.*;
import Operaciones.Validaciones;
import Vistas.RegistroVenta;
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
public class ControladorRegistroVenta {
    RegistroVenta ventana;
    Validaciones x=new Validaciones();
    DefaultTableModel modelo = new DefaultTableModel();
    public ControladorRegistroVenta(RegistroVenta ventana){
    this.ventana=ventana;
    this.ventana.getContentPane().setBackground(Color.GRAY);
    this.ventana.setTitle("Registros");
    cargarEscuchadores();
    IniciaTabla();
    this.ventana.setVisible(true);
    
    }
    
    private void IniciaTabla(){
    modelo = new DefaultTableModel();
        modelo.addColumn("Numero de renta");
        modelo.addColumn("Id pelicula");
        modelo.addColumn("Curp cliente");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha de la renta");
        modelo.addColumn("Fecha de devolución");
        
        this.ventana.getTablaRegistro().setModel(modelo);
        String[] mios = new String[6];
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
                modelo.addRow(mios);
            }
            this.ventana.getTablaRegistro().setModel(modelo);

        } catch (SQLException ex) {
            
    }
    }
    
    private void cargarEscuchadores(){
    this.ventana.getBtn_AgregarRegistro().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            AgregaRegistro();
        }
    });
            this.ventana.getBtn_ActualizarRegistro().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Actualizaregistro();
        }
    });
            this.ventana.getBtn_EliminarRegistro().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            EliminaRegistro();
        }
    });
            
            this.ventana.getTablaRegistro().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e){
        MouseEvent t=e;
    ObtenRenglon(t);
    }
    });
   this.ventana.getBtn_CerrarRegistro().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cierra();
        }
    });
   this.ventana.getBtn_LimpiarRegistros().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           LimpiaDatos();
        }
    });
  
  this.ventana.getTxt_NumeroDeRenta().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números nadamás");
                
            }
            
        }

   });
  
    }
    private void LimpiaDatos(){
        this.ventana.getTxt_NumeroDeRenta().setText("");
    this.ventana.getTxt_IDPelicula().setText("");
    this.ventana.getTxt_Cantidad().setText("");
    this.ventana.getTxt_CurpCliente().setText("");
    this.ventana.getTxt_FechaRenta().setText("");
    this.ventana.getTxt_FechaDevolución().setText("");
    }
    
    private void Cierra(){
    this.ventana.setVisible(false);
    }
    private void ObtenRenglon(MouseEvent e){
    ArrayList<String> a=new ArrayList<>();
        for(int x=0; x<6; x++){
            Object c=null;
        c=this.ventana.getTablaRegistro().getValueAt(this.ventana.getTablaRegistro().getSelectedRow(), x);
        a.add(c.toString());
        }
        this.ventana.getTxt_NumeroDeRenta().setText(a.get(0));
        this.ventana.getTxt_IDPelicula().setText(a.get(1));
        this.ventana.getTxt_CurpCliente().setText(a.get(2));
        this.ventana.getTxt_FechaRenta().setText(a.get(4));
        this.ventana.getTxt_FechaDevolución().setText(a.get(5));
        this.ventana.getTxt_Cantidad().setText(a.get(3));
        
    }
    private void AgregaRegistro(){
        if(x.ValidaFecha(this.ventana.getTxt_FechaDevolución().getText())==false){
        JOptionPane.showMessageDialog(null, "Introduzca bien la fecha de devolucion");
        }
        else
            if(x.ValidaFecha(this.ventana.getTxt_FechaRenta().getText())==false){
            JOptionPane.showMessageDialog(null, "Introduzca bien la fecha de renta de la pelicula");
            }
            else{
    Agregar.agregarRegistroVenta(this.ventana.getTxt_IDPelicula().getText(),this.ventana.getTxt_CurpCliente().getText(),this.ventana.getTxt_Cantidad().getText(),this.ventana.getTxt_FechaRenta().getText(),this.ventana.getTxt_FechaDevolución().getText());
Eliminar.descontarpeliculas(this.ventana.getTxt_Cantidad().getText(), this.ventana.getTxt_IDPelicula().getText());
            }
    IniciaTabla();
    }
    private void Actualizaregistro(){
       if(x.ValidaFecha(this.ventana.getTxt_FechaDevolución().getText())==false){
        JOptionPane.showMessageDialog(null, "Introduzca bien la fecha de devolucion");
        }
        else
            if(x.ValidaFecha(this.ventana.getTxt_FechaRenta().getText())==false){
            JOptionPane.showMessageDialog(null, "Introduzca bien la fecha de renta de la pelicula");
            }
            else{
    Modificar.modficarRegistroVenta(this.ventana.getTxt_NumeroDeRenta().getText(),this.ventana.getTxt_IDPelicula().getText(),this.ventana.getTxt_CurpCliente().getText(),this.ventana.getTxt_Cantidad().getText(),this.ventana.getTxt_FechaRenta().getText(),this.ventana.getTxt_FechaDevolución().getText());    
   
    }
    IniciaTabla();
    }
    private void EliminaRegistro(){
    Eliminar.eliminarRegistroVenta(this.ventana.getTxt_NumeroDeRenta().getText());
    Agregar.AgregaCantidad(this.ventana.getTxt_Cantidad().getText(), this.ventana.getTxt_IDPelicula().getText());
    IniciaTabla();
    }
    private ResultSet Consulta() throws SQLException{
    Conexion obj=new Conexion();
        obj.conectar();
        String sql="select * from registroventa";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }
}
