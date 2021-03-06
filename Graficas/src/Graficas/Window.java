package Graficas;

import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Window extends javax.swing.JFrame {

    JFreeChart Grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public Window() {
        initComponents();
        Datos.addValue(1, "Negocio 1", "Lunes");
        Datos.addValue(2, "Negocio 1", "Martes");
        Datos.addValue(3, "Negocio 1", "Miércoles");
        Datos.addValue(4, "Negocio 1", "Jueves");
        Datos.addValue(5, "Negocio 1", "Viernes");
        Datos.addValue(6, "Negocio 1", "Sábado");
        Datos.addValue(7, "Negocio 1", "Domingo");

        Datos.addValue(2, "Negocio 2", "Lunes");
        Datos.addValue(4, "Negocio 2", "Martes");
        Datos.addValue(6, "Negocio 2", "Miércoles");
        Datos.addValue(8, "Negocio 2", "Jueves");
        Datos.addValue(10, "Negocio 2", "Viernes");
        Datos.addValue(12, "Negocio 2", "Sábado");
        Datos.addValue(14, "Negocio 2", "Domingo");

        Grafica = ChartFactory.createLineChart("Visitas diarias",
                "Días", "Visitas", Datos,
                PlotOrientation.VERTICAL, true, true, false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Graficar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jButton1)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Creamos un Panel y colocamos dentro nuestra gráfica
        ChartPanel Panel = new ChartPanel(Grafica);
        //Creamos un nuevo Frame para nuestra gráfica
        JFrame Ventana = new JFrame("JFreeChart");
        //Agregamos el panel a la nueva ventana
        Ventana.getContentPane().add(Panel);
        //Reseteamos la ventana
        Ventana.pack();
        //Hacemos visible la nueva ventana
        Ventana.setVisible(true);
        //Establecemos la acción que hará la ventana cuando 
        //se presione el botón de cerrar la ventana
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
