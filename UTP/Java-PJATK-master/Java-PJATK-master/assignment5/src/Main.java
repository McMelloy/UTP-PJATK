import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Thread req1 = new Thread(new Requester());
        req1.start();

        Thread req2 = new Thread(new Requester());
        req2.start();

        Thread req3 = new Thread(new Requester());
        req3.start();

        Thread req4 = new Thread(new Requester());
        req4.start();


        Thread service1 = new Thread(new Service());
        service1.start();

        Thread service2 = new Thread(new Service());
        service2.start();

        Thread service3 = new Thread(new Service());
        service3.start();

        Thread service4 = new Thread(new Service());
        service4.start();
    }
}
