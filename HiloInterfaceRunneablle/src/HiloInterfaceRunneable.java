
import java.util.Scanner;


public class HiloInterfaceRunneable {

    public static void main(String[] args) throws InterruptedException{
        Scanner x=new Scanner(System.in);
        System.out.println("¿Cuántos hilos desea crear?");
        int b=x.nextInt();
        System.out.println("¿Tiempo de ejecución entre hilos?");
        int c=x.nextInt();
        
        for(int i=0;i<b;i++){
        Thread mio = new Thread(new MiHilo(i));
        mio.start();
        Thread.sleep(c);
        }
        System.out.println("Fin del programa");
        
    }
    
    
}
class MiHilo  implements Runnable {
    private int a;
    MiHilo(int a){
    this.a=a;
    }
public void run() {
System.out.println( "El hilo: "+a+" está corriendo");


}
}
