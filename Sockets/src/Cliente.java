
import java.io.*;
import java.net.Socket;


public class Cliente {

    public static void main(String[] args) throws Exception{
        Cliente client=new Cliente();
        client.corre();
    }
    
    public void corre() throws IOException{
    Socket sock=new Socket("localhost",10000);
    PrintStream PS=new PrintStream(sock.getOutputStream());
    PS.println("Hola al servidor desde el cliente!!!");
    InputStreamReader IR=new InputStreamReader(sock.getInputStream());
    BufferedReader BR=new BufferedReader(IR);
    String Mensaje=BR.readLine();
        System.out.println(Mensaje);
    
    }
    
}
