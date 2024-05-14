package synchronization;

public class Data {
    private String packet;

    private boolean transfer = true;


    public synchronized String receive() {
        System.out.println("received data");
        System.out.println("Transfer status: " + transfer);
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }

        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet) {
        System.out.println("sending data. Packet: " + packet);
        System.out.println("Transfer status: " + transfer);
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }
}
