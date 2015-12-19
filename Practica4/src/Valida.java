
public class Valida {

    public boolean validar(char c){
    boolean valor = true;          
        
            if (!Character.isDigit(c)&&Character.isLetter(c)||Character.isWhitespace(c)) {
                valor= false;
                
            }            
            return valor;         
        
    }
    public boolean validar2(char c){
    boolean valor = true;          
        
            if (Character.isDigit(c)) {
                valor= false;
                
            }            
            return valor;         
        
    }
    
}
