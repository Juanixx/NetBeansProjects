package principal;

import controlador.controlador;
import modelo1.modelo;
import vista.vista1;

public class principal {
    public static void main(String[] args) {
vista1 v=new vista1();
modelo m=new modelo();
controlador c=new controlador( m, v);
c.sumar();


    }
}
