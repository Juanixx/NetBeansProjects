 
package Controladores;
import Operaciones.Agregar;
import Agregar.AgregarCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CtrlVista {
    AgregarCliente ventana;

    public AgregarCliente getVentana() {
        return ventana;
    }

    public void setVentana(AgregarCliente ventana) {
        this.ventana = ventana;
        this.ventana.setVisible(true);
        cargarescuchadores();
    }
    private void cargarescuchadores(){
    this.ventana.getAgregar().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirVentanaAgregar();
        }
    });
    
    private void abrirVentanaAgregar(){
    Agregar obj = new Agregar(new Agregar(this.ventana,true));
    }
    
    }
    
}
