package synchronization;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{
    private final Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        System.out.println("Receiver started");
        for(String receivedMessage = load.receive();
            !"End".equals(receivedMessage);
            receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
