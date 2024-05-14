public class MyThread extends Thread {
    private final String name;
    private final TestService service;

    public MyThread(TestService service, String name) {
        super(name);
        this.service = service;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is running");
        service.setMessage(service.getMessage().concat(" ").concat(this.name));
        System.out.println(service.getMessage());
    }
}
