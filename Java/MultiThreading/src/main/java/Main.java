import synchronization.Data;
import synchronization.Receiver;
import synchronization.Sender;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
