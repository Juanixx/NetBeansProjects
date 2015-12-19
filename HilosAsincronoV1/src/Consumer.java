import java.util.Random;
 
public class Consumer implements Runnable {
    private Drop drop;
 
    public Consumer(Drop drop) {
        this.drop = drop;
    }
 
    public void run() {
        Random random = new Random();
        for (String message = drop.take();
             ! message.equals("Fin del programa");
             message = drop.take()) {
            System.out.format("Se recibió la letra: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}     