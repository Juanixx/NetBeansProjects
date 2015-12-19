import java.util.Random;
 
public class Producer extends Thread {
    private Drop drop;
 
    public Producer(Drop drop) {
        this.drop = drop;
    }
 
    public void run() {
        String importantInfo[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"
                + "Ñ","O","P","Q","R","S","T","V","W","X","Y","Z"
        };
        Random random = new Random();
 
        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        drop.put("Fin del programa");
    }
}      