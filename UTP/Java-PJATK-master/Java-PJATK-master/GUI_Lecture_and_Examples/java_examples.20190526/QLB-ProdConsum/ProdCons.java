// QLB-ProdConsum/ProdCons.java
 
import java.util.LinkedList;

public class ProdCons {

    static volatile boolean isDone = false;

    public static void main(String[] args) {

        int numOfProducers = 10;
        int numOfConsumers = 7;
        int  lengthOfQueue = 5;
        LinkedList<Object> queue = new LinkedList<Object>();

        for (int i = 0; i < numOfProducers; ++i)
            new Producer(queue,lengthOfQueue,i).start();
        for (int i = 0; i < numOfConsumers; ++i)
            new Consumer(queue,i).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignore) { }

        synchronized(queue) {
            isDone = true;
            System.err.println("KILLING");
            queue.notifyAll();
        }
    }
}
