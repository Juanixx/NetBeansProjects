
package Controladores;

import Operaciones.Agregar;
import Operaciones.Conexion;
import Operaciones.Eliminar;
import Operaciones.Modificar;
import Operaciones.Validaciones;
import Vistas.Clientes;
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

public class ControladorClientes {
    Clientes ventana;
    Validaciones x=new Validaciones();
    public ControladorClientes(Clientes ventana){
    this.ventana=ventana;
    this.ventana.getContentPane().setBackground(Color.GRAY);
    this.ventana.setTitle("Clientes");
    cargarEscuchadores();
    IniciaTabla();
    this.ventana.setVisible(true);
    }
    
    private void IniciaTabla(){
    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Curp");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Sexo");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        this.ventana.getTablaClientes().setModel(modelo);
        String[] mios = new String[13];
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
            this.ventana.getTablaClientes().setModel(modelo);

        } catch (SQLException ex) {
            
    }
    }
    
    private void cargarEscuchadores(){
    this.ventana.getBtnAgregarNuevo_Cliente().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            AgregaCliente();
        }
    });
    this.ventana.getBtn_ModificarCliente().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ModificaCliente();
        }
    });
    this.ventana.getBtn_EliminarCliente().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            EliminaCliente();
        }
    });
    this.ventana.getBtn_CerrarClientes().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cierra();
        }
    });
    this.ventana.getTablaClientes().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e){
        MouseEvent t=e;
    ObtenRenglon(t);
    }
        });
   this.ventana.getBtm_LimpiarDatosCliente().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           LimpiaDatos();
        }
    });
   
   this.ventana.getTxtNombre_Cliente().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetras(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras nadamás");
                
            }
            
        }

   });
   
   this.ventana.getTxtApellido_Cliente().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaLetras(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca letras nadamás");
                
            }
            
        }

   });
   this.ventana.getTxtTelefono_Cliente().addKeyListener(new KeyAdapter() {
   @Override
        public void keyTyped(KeyEvent e) {
            if(x.ValidaDigitos(e.getKeyChar())==false){
            e.consume();
            JOptionPane.showMessageDialog(null, "Introduzca numeros nadamás");
                
            }
            
        }

   });
   this.ventana.getTxtSexo_Cliente().setEditable(false);
   this.ventana.getComboSexo().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            PonerSexo();
        }
    });
   
   
    }
    private void PonerSexo(){
    this.ventana.getTxtSexo_Cliente().setText(this.ventana.getComboSexo().getSelectedItem().toString());
    }
    private void Cierra(){
    this.ventana.setVisible(false);
    }
    private void ObtenRenglon(MouseEvent e){
    ArrayList<String> a=new ArrayList<>();
        for(int x=0; x<6; x++){
            Object c=null;
        c=this.ventana.getTablaClientes().getValueAt(this.ventana.getTablaClientes().getSelectedRow(), x);
        a.add(c.toString());
        System.out.println(c.toString());
        }
        this.ventana.getTxtcurp_Cliente().setText(a.get(0));
        this.ventana.getTxtNombre_Cliente().setText(a.get(1));
        this.ventana.getTxtApellido_Cliente().setText(a.get(2));
        this.ventana.getTxtSexo_Cliente().setText(a.get(3));
        this.ventana.getTxt_DireccionCliente().setText(a.get(4));
        this.ventana.getTxtTelefono_Cliente().setText(a.get(5));
        
    }
    
    private void AgregaCliente(){
        Agregar.agregarCliente(this.ventana.getTxtcurp_Cliente().getText(), this.ventana.getTxtNombre_Cliente().getText(), this.ventana.getTxtApellido_Cliente().getText(), this.ventana.getTxtSexo_Cliente().getText(), this.ventana.getTxt_DireccionCliente().getText(), this.ventana.getTxtTelefono_Cliente().getText());
    IniciaTabla();
    }
    
    private void ModificaCliente(){
    Modificar.modficarCliente(this.ventana.getTxtcurp_Cliente().getText(), this.ventana.getTxtNombre_Cliente().getText(), this.ventana.getTxtApellido_Cliente().getText(), this.ventana.getTxtSexo_Cliente().getText(), this.ventana.getTxt_DireccionCliente().getText(), this.ventana.getTxtTelefono_Cliente().getText());
    IniciaTabla();
    }
    
    private void EliminaCliente(){
    Eliminar.eliminarCliente(this.ventana.getTxtcurp_Cliente().getText());
    IniciaTabla();
    }
    
    private ResultSet Consulta() throws SQLException{
    Conexion obj=new Conexion();
        obj.conectar();
        String sql="select * from cliente";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }
    private void LimpiaDatos(){
        this.ventana.getTxtcurp_Cliente().setText("");
    this.ventana.getTxtNombre_Cliente().setText("");
    this.ventana.getTxtApellido_Cliente().setText("");
    this.ventana.getTxtSexo_Cliente().setText("");
    this.ventana.getTxt_DireccionCliente().setText("");
    this.ventana.getTxtTelefono_Cliente().setText("");
    }
    
    /*private void cargarComboCurp(){
    ResultSet dos;
    this.ventana.getComboSexo().setModel(new DefaultComboBoxModel());
        try {
            dos = ConsultaCurps();

            while (dos.next()) {
                int i=1;
                String b = dos.getString(i);
            }

        } catch (SQLException ex) {
            
    }
    }
    private ResultSet ConsultaCurps() throws SQLException{
    Conexion obj=new Conexion();
        obj.conectar();
        String sql="select curp from cliente";
        ResultSet uno=obj.realizarConsulta(sql);
        obj.desconectar();
        return uno;
    }*/
}
