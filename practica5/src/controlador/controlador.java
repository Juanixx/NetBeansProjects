
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo1.modelo;
import vista.vista1;

public class controlador {
 private modelo modelo;
 private vista1 vista1;

    public controlador(modelo modelo, vista1 vista1) {
        this.modelo = modelo;
        this.vista1 = vista1;
        
        this.vista1.getSuma().addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
          
            }
        });
    }

    public controlador(vista1 v, modelo m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void sumar(){
    this.modelo.setValor1(Integer.parseInt(this.vista1.getTx1().getText()));
    this.modelo.setValor2(Integer.parseInt(this.vista1.getTx2().getText()));
    this.modelo.sumar();
    this.vista1.getTx3().setText(String.valueOf(this.modelo.getTotal()));
    }
    

}
