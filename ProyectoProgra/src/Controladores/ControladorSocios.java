

package Controladores;
import Operaciones.Agregar;
import Operaciones.Conexion;
import Operaciones.Eliminar;
import Operaciones.Modificar;
import Operaciones.Validaciones;
import Vistas.Socios;
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
public class ControladorSocios {
    Validaciones x=new Validaciones();
    Socios ventana;
    public ControladorSocios(Socios ventana){
    this.ventana=ventana;
    this.ventana.getContentPane().setBackground(Color.LIGHT_GRAY);
    this.ventana.setTitle("Socios");
    cargarEscuchadores();
    IniciaTabla();
    this.ventana.setVisible(true);
    }
    
    private void IniciaTabla(){
    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID socio");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        this.ventana.getTablaSocio().setModel(modelo);
        String[] mios = new String[4];
        ResultSet dos;
        try {
            dos = Consulta();

            while (dos.next()) {
                mios[0] = dos.getString(1);
                mios[1] = dos.getString(2);
                mios[2] = dos.getString(3);
                mios[3] = dos.getString(4);
                modelo.addRow(mios);
            }
            this.ventana.getTablaSocio().setModel(modelo);

        } catch (SQLException ex) {
            
    }
    }
    
    private void cargarEscuchadores(){
    this.ventana.getBtnAgregarNuevo_Socio().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            AgregaSocio();
        }
    });
    this.ventana.getBtn_ActualizarSocio().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ActualizaSocio();
        }
    });
    this.ventana.getBtn_EliminarSocio().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            EliminaSocio();
        }
    });
    
    this.ventana.getTablaSocio().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e){
        MouseEvent t=e;
    ObtenRenglon(t);
    }
    });
   this.ventana.getBtn_CerrarSocios().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cierra();
        }
    });
   
   this.ventana.getBtn_LimpiarDatosSocios().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            LimpiaDatos();
        }
    });
   
   this.ventana.getTxtID_Socio().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetrasYDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca números y letras nadamás");
                
            }
            
        }

   });this.ventana.getTxtNombre_Socio().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetras(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras nadamás");
                
            }
            
        }

   });
   this.ventana.getTxtApellido_Socio().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetras(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras nadamás");
                
            }
            
        }

   });
   
   this.ventana.getTxtTelefono_Socio().addKeyListener(new KeyAdapter() {
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
    this.ventana.getTxtID_Socio().setText("");
    this.ventana.getTxtNombre_Socio().setText("");
    this.ventana.getTxtApellido_Socio().setText("");
    this.ventana.getTxtTelefono_Socio().setText("");
    }
    private void Cierra(){
    this.ventana.setVisible(false);
    }
    private void ObtenRenglon(MouseEvent e){
    ArrayList<String> a=new ArrayList<>();
        for(int x=0; x<4; x++){
            Object c=null;
        c=this.ventana.getTablaSocio().getValueAt(this.ventana.getTablaSocio().getSelectedRow(), x);
        a.add(c.toString());
        }
        this.ventana.getTxtID_Socio().setText(a.get(0));
        this.ventana.getTxtNombre_Socio().setText(a.get(1));
        this.ventana.getTxtApellido_Socio().setText(a.get(2));
        this.ventana.getTxtTelefono_Socio().setText(a.get(3));
    }
    
    private void AgregaSocio(){
    Agregar.agregarSocio(this.ventana.getTxtID_Socio().getText(), this.ventana.getTxtNombre_Socio().getText(), this.ventana.getTxtApellido_Socio().getText(), this.ventana.getTxtTelefono_Socio().getText());
    IniciaTabla();
    }
    private void ActualizaSocio(){
    Modificar.modficarSocio(this.ventana.getTxtID_Socio().getText(), this.ventana.getTxtNombre_Socio().getText(), this.ventana.getTxtID_Socio().getText(), this.ventana.getTxtApellido_Socio().getText(), this.ventana.getTxtTelefono_Socio().getText());
    IniciaTabla();
    }
    private void EliminaSocio(){
    Eliminar.eliminarSocio(this.ventana.getTxtID_Socio().getText());
    IniciaTabla();
    }
    private ResultSet Consulta() throws SQLException{
    Conexion obj=new Conexion();
        obj.conectar();
        String sql="select * from socio";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }
}
