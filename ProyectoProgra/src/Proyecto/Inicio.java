
package Proyecto;
import Controladores.ControladorPrincipal;
import Vistas.VistaPrincipal;
public class Inicio {
    public static void main(String[] args) {
        
       ControladorPrincipal obj = new ControladorPrincipal(new VistaPrincipal()); 
    }
}
