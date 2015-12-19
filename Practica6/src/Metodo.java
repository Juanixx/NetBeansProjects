
import java.util.ArrayList;


public class Metodo {
    ArrayList<String>Nombres=new ArrayList<>();
    ArrayList<String>Apellidos=new ArrayList<>();
            
    public boolean Compara(String Nombre,String Apellido, boolean x){
        
        for(int c=0; c<=Nombres.size(); c++){
            if(Nombres.get(c).toString().equals(Nombre)&&Apellidos.get(c).toString().equals(Apellido)){
                
                Nombres.add(Nombre);
                Apellidos.add(Apellido);
                break;
            }
            else{
            x=true;
            }
            
    }
    
    return x;
    }}
    
