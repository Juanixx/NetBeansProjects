
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author JuanEduardo
 */
public class HiloInterfaceThread {
    
    public static void main(String[] args) throws InterruptedException{
        Scanner x=new Scanner(System.in);
        System.out.println("¿Cuántos hilos desea crear?");
        int b=x.nextInt();
        System.out.println("¿Tiempo de ejecución entre hilos?");
        int c=x.nextInt();
        
        for(int i=0;i<=b;i++){
        MiHilo mio = new MiHilo(i);
        mio.start();try{
        MiHilo.sleep(c);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        System.out.println("Fin del programa");
        
    }
    
    
}
class MiHilo  extends Thread {
    private int a;
    MiHilo(int a){
    this.a=a;
    }
public void run() {
System.out.println( "El hilo: "+a+" está corriendo");
}
}
