import java.math.BigDecimal;
import java.util.Scanner;


public class Expnencial {

    public static void main(String[] args) {
        String cad;
        Scanner mio=new Scanner(System.in);
        cad=mio.nextLine();
        String res[]=cad.split(" ");
        BigDecimal k=new BigDecimal(res[0]);
        int t=Integer.parseInt(res[1]);
        System.out.println(k.pow(t).toPlainString());
    }
    
}
