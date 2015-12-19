
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Animal extends Thread {
    String nombre;
    int limite;
    JLabel label;
    
    public Animal(String nombre, int limite,JLabel label){
    this.nombre=nombre;
    this.limite=limite;
    this.label=label;
    }
    
    @Override
    public void run(){
    for(int n=0; n<limite; n++){
        System.out.println(nombre+" avanza");
        label.setLocation(n,0);
        try {
            Thread.sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        JOptionPane.showMessageDialog(null, nombre+" ha llegado a la meta");
        System.out.println(nombre+" ha llegado a la meta ");
        yield();
    }
}
