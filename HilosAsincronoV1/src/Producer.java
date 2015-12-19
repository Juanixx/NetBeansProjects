import java.util.Random;
 
public class Producer implements Runnable {
    private Drop drop;
 
    public Producer(Drop drop) {
        this.drop = drop;
    }
 
    public void run() {
        String importantInfo[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N" ,"O","P","Q","R","S","T","V","W","X","Y","Z"
        };
        Random random = new Random();
        String b="";
        int a=0;
        while(a<=24){
            int c=random.nextInt(24);
            if(!b.contains(Integer.toString(c))){
            drop.put(importantInfo[c]);
                //System.out.print("Numero: "+c+"    ");
            b=b+" "+c;
            a++;
            
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
            
            }
        }
        drop.put("Fin del programa");
    }
}      