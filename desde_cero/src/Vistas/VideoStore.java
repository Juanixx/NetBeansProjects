/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Vistas.Borrar.BorrarPelicula;
import Agregar.AgregarCliente;
import Agregar.AgregarEncargado;
import Agregar.AgregarSocio;
import Agregar.AgregarPelicula;
import Vistas.Borrar.BorrarCliente;
import Vistas.Borrar.BorrarEncargado;
import Vistas.Borrar.BorrarSocio;
import Vistas.modificar.ModificarCliente;
import Vistas.modificar.ModificarEncargado;
import Vistas.modificar.ModificarPelicula;
import Vistas.modificar.ModificarSocio;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class VideoStore extends javax.swing.JFrame {

    /**
     * Creates new form VideoStore
     */
    public VideoStore() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Video.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false); ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Fondo.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }

    public VideoStore(VideoStore videoStore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuVideoStore = new javax.swing.JMenuBar();
        Catalogo = new javax.swing.JMenu();
        Clientes = new javax.swing.JMenu();
        Socios = new javax.swing.JMenu();
        Encargado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Catalogo.setText("Catalogo");
        MenuVideoStore.add(Catalogo);

        Clientes.setText("Clientes");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        MenuVideoStore.add(Clientes);

        Socios.setText("Socios");
        MenuVideoStore.add(Socios);

        Encargado.setText("Encargado");
        MenuVideoStore.add(Encargado);

        setJMenuBar(MenuVideoStore);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenu getCatalogo() {
        return Catalogo;
    }

    public void setCatalogo(JMenu Catalogo) {
        this.Catalogo = Catalogo;
    }

    public JMenu getEncargado() {
        return Encargado;
    }

    public void setEncargado(JMenu Encargado) {
        this.Encargado = Encargado;
    }

    public JMenuBar getMenuVideoStore() {
        return MenuVideoStore;
    }

    public void setMenuVideoStore(JMenuBar MenuVideoStore) {
        this.MenuVideoStore = MenuVideoStore;
    }

    public JMenu getSocios() {
        return Socios;
    }

    public void setSocios(JMenu Socios) {
        this.Socios = Socios;
    }

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VideoStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoStore().setVisible(true);
            }
        });
    }

    public JMenu getClientes() {
        return Clientes;
    }

    public void setClientes(JMenu Clientes) {
        this.Clientes = Clientes;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Catalogo;
    private javax.swing.JMenu Clientes;
    private javax.swing.JMenu Encargado;
    private javax.swing.JMenuBar MenuVideoStore;
    private javax.swing.JMenu Socios;
    // End of variables declaration//GEN-END:variables

}