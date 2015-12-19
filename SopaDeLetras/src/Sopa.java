
public class Sopa {
    private String[] palabras;
        private String[][] SopaDeLetras;
    public static void main(String[] args) {
        Sopa mia=new Sopa();
        mia.CargarMatriz();
        mia.PalabraABuscar();
        mia.BuscarPalabras();
        
    }
    private void CargarMatriz(){
    SopaDeLetras=new String[][]{
        {"A","H","D","Y","F","A"},
        {"R","O","M","A","S","L"},
        {"A","N","A","T","I","M"}
        };
    }
    
    private void PalabraABuscar(){
    palabras=new String[]{
    "ANA","ROMA"
    };
    }
    
    public int BuscaHorizontal(String palabra){
    int alaizquierda=0;
    for(int i=0; i<SopaDeLetras.length;i++){
    
        for(int j=0; j<SopaDeLetras[0].length-palabra.length(); j++){
        String conjuntoletras="";
            for(int k=0; k<palabra.length();k++){
            conjuntoletras+=SopaDeLetras[i][j+k];
            }
            if(conjuntoletras.equals(palabra)){
            alaizquierda++;
            }  
        }
    }
    
    return alaizquierda;
    }
    
    public void BuscarPalabras(){
    for(int i=0; i<palabras.length;i++){
    
        String palabra=palabras[i];
        System.out.println("Se encontraron: "+BuscaHorizontal(palabra)+" de la palabra "+palabra);
        
    }
    }
    
}
