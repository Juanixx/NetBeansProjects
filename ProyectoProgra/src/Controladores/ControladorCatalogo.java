
package Controladores;
import Operaciones.*;
import Reportes.reportin;
import Vistas.Catalogo;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ControladorCatalogo {
    Catalogo ventana;
    Validaciones x=new Validaciones();
    DefaultTableModel modelo = new DefaultTableModel();
    reportin bmw=new reportin();
    public ControladorCatalogo(Catalogo ventana) {
        this.ventana = ventana;
        this.ventana.getContentPane().setBackground(Color.GRAY);
        this.ventana.setTitle("Catálogo");
        this.ventana.getPanel().setBounds(100, 100, 100, 100);
        cargarEscuchadores();
        IniciaTabla();
        this.ventana.setVisible(true);
        
    }
    private void IniciaTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("ID pelicula");
        modelo.addColumn("Título");
        modelo.addColumn("Clasificación");
        modelo.addColumn("Costo por día");
        modelo.addColumn("Cantidad disponibles");
        modelo.addColumn("ID socio");
        this.ventana.getTablaCatalogo().setModel(modelo);
        
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
            this.ventana.getTablaCatalogo().setModel(modelo);
        } catch (SQLException ex) {
            
    }
    }
    
    private void cargarEscuchadores(){
    this.ventana.getBtnAgregarNueva_Pelicula().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AgregaPelicula();
        }
    });
    this.ventana.getBtn_ActualizarPelicula().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ActualizaPelicula();
        }
    });
    this.ventana.getBtn_EliminarPelicula().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {    
                EliminaPelicula();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    this.ventana.getBtn_AgregarPelicula().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AgregaPeliculas();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    this.ventana.getBtn_EliminaCantidadPeliculas().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuitarPeliculas();
        }
    });
    
    this.ventana.getBtn_CerrarCatalogo().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cierra();
        }
    });
    
    this.ventana.getTablaCatalogo().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e){
        MouseEvent t=e;
    ObtenRenglon(t);
    }
    });
   this.ventana.getBtn_LimpiarDatosCatalogo().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            LimpiaTextos();
        }
    });
this.ventana.getTxtID_Pelicula().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetrasYDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras y números nadamás");
                
            }}

});

this.ventana.getTxtNombre_Pelicula().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetras(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras nadamás");
                
            }}

});
this.ventana.getTxtClasificacion_Pelicula().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaUnDigito(ObtenTCatalogo())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca una letra nadamás (A,B ó C)");
                
            }}

});
this.ventana.getTxt_CostoPorDia().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
           if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números nadamás");
                
            }}

});
this.ventana.getTxt_PeliculasDisponibles().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
           if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números nadamás");
                
            }}

});
   this.ventana.getTxt_AgregarPelicula().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
           if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números nadamás");
                
            }}

});
this.ventana.getTxtIDSocio_Pelicula().addKeyListener(new KeyAdapter() {
@Override
        public void keyTyped(KeyEvent e) {
           if(x.ValidaLetrasYDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras y números nadamás");
                
            }}

});

   
   
    }
    private String ObtenTCatalogo(){
    return this.ventana.getTxtClasificacion_Pelicula().toString();
    }
    private void ObtenRenglon(MouseEvent e){
    ArrayList<String> a=new ArrayList<>();
        for(int x=0; x<6; x++){
            Object c=null;
        c=this.ventana.getTablaCatalogo().getValueAt(this.ventana.getTablaCatalogo().getSelectedRow(), x);
        a.add(c.toString());
        }
        this.ventana.getTxtID_Pelicula().setText(a.get(0));
        this.ventana.getTxtNombre_Pelicula().setText(a.get(1));
        this.ventana.getTxtClasificacion_Pelicula().setText(a.get(2));
        this.ventana.getTxt_CostoPorDia().setText(a.get(3));
        this.ventana.getTxt_PeliculasDisponibles().setText(a.get(4));
        this.ventana.getTxtIDSocio_Pelicula().setText(a.get(5));
    }
    
    private void AgregaPelicula(){
        
    Agregar.agregarPelicula(this.ventana.getTxtID_Pelicula().getText(), this.ventana.getTxtNombre_Pelicula().getText(), this.ventana.getTxtClasificacion_Pelicula().getText(),this.ventana.getTxt_CostoPorDia().getText(),this.ventana.getTxt_PeliculasDisponibles().getText(), this.ventana.getTxtIDSocio_Pelicula().getText());
    IniciaTabla();
        }
    private void ActualizaPelicula(){
    Modificar.modficarPelicula(this.ventana.getTxtID_Pelicula().getText(), this.ventana.getTxtNombre_Pelicula().getText(), this.ventana.getTxtID_Pelicula().getText(), this.ventana.getTxtClasificacion_Pelicula().getText(),this.ventana.getTxt_CostoPorDia().getText(),this.ventana.getTxt_PeliculasDisponibles().getText(), this.ventana.getTxtIDSocio_Pelicula().getText());
    IniciaTabla();
    }
    private void EliminaPelicula() throws SQLException{
    Eliminar.eliminarPelicula(this.ventana.getTxtID_Pelicula().getText());
    IniciaTabla();
    }
    private ResultSet Consulta() throws SQLException{
    Conexion obj=new Conexion();
        obj.conectar();
        String sql="select * from catalogo";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }
    private void Cierra(){
    this.ventana.setVisible(false);
    }
    
    private void LimpiaTextos(){
    this.ventana.getTxtID_Pelicula().setText("");
    this.ventana.getTxtNombre_Pelicula().setText("");
    this.ventana.getTxtClasificacion_Pelicula().setText("");
    this.ventana.getTxt_CostoPorDia().setText("");
    this.ventana.getTxt_PeliculasDisponibles().setText("");
    this.ventana.getTxtIDSocio_Pelicula().setText("");
    }
    
    private void AgregaPeliculas() throws SQLException{
    Agregar.AgregarCantidadAPelicula(this.ventana.getTxt_AgregarPelicula().getText(),this.ventana.getTxt_PeliculasDisponibles().getText(), this.ventana.getTxtID_Pelicula().getText());
    IniciaTabla();
    }
    
    private void QuitarPeliculas(){
    Eliminar.quitarpeliculas(this.ventana.getTxt_AgregarPelicula().getText(),this.ventana.getTxt_PeliculasDisponibles().getText(), this.ventana.getTxtID_Pelicula().getText());
    IniciaTabla();
    }
    
}
