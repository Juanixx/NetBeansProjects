/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import com.sun.glass.events.KeyEvent;

/**
 *
 * @author JuanEduardo
 */
public class Validaciones {
 
    /**
     * @param c
     * @return 
     */
   String []meses={"1","2","3","4","5","6","7","8","9","10","11","12"};
   String []dias={"31","28","31","30","31","30","31","31","30","31","29","31"};
    public boolean ValidaLetras(Character c) {
        boolean b;
        if(Character.isLetter(c)||Character.isWhitespace(c)||c==KeyEvent.VK_BACKSPACE){
        b=true;
        }
        else
            b=false;
        return b;
    }
    public boolean ValidaDigitos(Character c) {
        boolean b=true;
        if(!Character.isDigit(c)||c==KeyEvent.VK_BACKSPACE){
        b=false;
        }
        return b;
    }
    
    public boolean ValidaLetrasYDigitos(Character c){
    boolean b=true;
    if(Character.isDigit(c)||Character.isLetter(c)||c==KeyEvent.VK_BACKSPACE){
    b=true;
    }else{
    b=false;
    }
    return b;
    }
    
    public boolean ValidaCaracteresYDigitos(Character c){
    boolean b=true;
    if(Character.isLetter(c)||c==KeyEvent.VK_BACKSPACE){
    b=false;
    }
    return b;
    }
    public boolean ValidaCaracteresYLetras(Character c){
    boolean b=true;
    if(Character.isDigit(c)||c==KeyEvent.VK_BACKSPACE){
    b=false;
    }
    return b;
    }
    public boolean ValidaGuionesYDigitos(Character c){
    boolean b=true;
    if(Character.isDigit(c)||c=='-'||c==KeyEvent.VK_BACKSPACE)
    {
    b=true;
    }else{
    b=false;
    }
    return b;
    }
    
    public boolean ValidaFecha(String c){
    boolean b=true;
    String year = "",z="nnnn-nn-nn";
    
    for(int y=0; y<c.length();y++){
    char v=c.charAt(y);
    if(Character.isDigit(v)){
    year+="n";
    }
    else{
    year+="-";
    }
    
    }
        if(year.equals(z)){
        System.out.println("Listo");
        String[] a=c.split("-");
            if(Integer.parseInt(a[0])>=1950&&Integer.parseInt(a[0])<=2014){
            for(int x=0;x<12;x++){
            if(meses[x].equals(a[1])){
            if(Integer.parseInt(a[2])<=Integer.parseInt(dias[x])&&Integer.parseInt(a[2])>=1){
                System.out.println("Bien hecho");
            }
            else{
                System.out.println("Corrije el dia");
                b=false;
                break;
            }
            }
            else{
                int o=0;
                if(o>11){
                System.out.println("Corrije el mes");
                b=false;
                
                }   }  }          
            }
            else{
                b=false;
                System.out.println("Corrije el año");              
            }
            
            }
        else{
            System.out.println("Escriba bien la fecha de nacimiento");
        }
            return b;
        }
    public boolean ValidaUnDigito(String h){
        boolean b=true;
    if(h.length()>2||h.charAt(1)!='A'||h.charAt(1)!='B'||h.charAt(1)!='C'){
        b=false;
    }
    return b;
    }
    
    }
    

