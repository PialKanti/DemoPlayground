package synchronization;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private final Data data;
    private static final String[] packets = {
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet",
            "End"
    };

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Sender started");
        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
