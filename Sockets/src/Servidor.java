import java.io.*;
import java.net.*;
public class Servidor {

    
    public static void main(String[] args) throws Exception{
        Servidor server=new Servidor();
        server.corre();
    }
    public void corre() throws Exception{
    ServerSocket servidorsocket=new ServerSocket();
    Socket sock=servidorsocket.accept();
    InputStreamReader IR= new InputStreamReader(sock.getInputStream());
    BufferedReader BR=new BufferedReader(IR);
    String mensaje=BR.readLine();
        System.out.println(mensaje);
         if(mensaje==null){
         } else {
             PrintStream PS=new PrintStream(sock.getOutputStream());
             PS.println("Mensaje recivido!!!");
        }
    }
   
    
}
