
public class Validaciones {
    
   
    
        public boolean Validar(String a)
        {
        
            boolean valor = true;
            
        for (int x = 0; x < a.length(); x++) {
            if (!Character.isDigit(a.charAt(x))) {
                valor= false;
                break;
            }
           
        }
              
     return valor;
    }
}

