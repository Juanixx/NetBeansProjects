
package Controladores;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ControladorPrincipal {
    
    VistaPrincipal ventana;
    public ControladorPrincipal(VistaPrincipal ventana) {
        this.ventana = ventana;
        this.ventana.setTitle("Video Store");
        ponerEscuchar();
        this.ventana.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Video.png")).getImage());
        ((JPanel)this.ventana.getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Fondo.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        this.ventana.getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        this.ventana.setVisible(true);
        
    }
    
    private void ponerEscuchar()
    {
       this.ventana.getBtnCatalogo().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               VeCatalogo();
           }
       });
       
    this.ventana.getBtnClientes().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               veClientes();
           }
       });
    
    this.ventana.getBtnSocios().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               veSocios();
           }
       });
    
    this.ventana.getBtn_Registro().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               veRegistro();
           }
       });
    this.ventana.getBtn_CerrarVentanaPrincipal().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               Cierra();
           }
       });
    this.ventana.getBtn_RegistroDevolución().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               VeDevoluciones();
           }
       });
    
    this.ventana.getBtn_ReportesCon().addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               veReportesSin();
           }
       });
    
    }
    private void veReportesSin(){
    ControladorReportesSin obj=new ControladorReportesSin(new ReportesSin(this.ventana,true));
    }
    private void VeDevoluciones(){
    ControladorRegistroDevolucion obj= new ControladorRegistroDevolucion(new RegistroDevolucion(this.ventana,true));
    }
    
    private void VeCatalogo()
    {
     
        ControladorCatalogo obj = new ControladorCatalogo(new Catalogo(this.ventana,true));
    
    }
    private void veClientes(){
    ControladorClientes obj=new ControladorClientes(new Clientes(this.ventana,true));
    }
    
    private void veSocios(){
    ControladorSocios obj=new ControladorSocios(new Socios(this.ventana,true));
    }
    
    private void veRegistro(){
    ControladorRegistroVenta obj=new ControladorRegistroVenta(new RegistroVenta(this.ventana,true));
    }
    
    private void Cierra(){
    System.exit(0);
    }
    
}
