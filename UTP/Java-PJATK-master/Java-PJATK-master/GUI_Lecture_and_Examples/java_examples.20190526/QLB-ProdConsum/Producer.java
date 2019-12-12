// QLB-ProdConsum/Producer.java
 
import java.util.LinkedList;

class Producer extends Thread {

    final LinkedList<Object>  queue;
    final int lengthOfQueue;
    final int id;

    Producer(LinkedList<Object> q, int len, int i) {
        queue         = q;
        lengthOfQueue = len;
        id            = i;
    }

    public void run() {
        while (true) {
            Object product = produce();
            synchronized(queue) {
                if (ProdCons.isDone) break;
                while (queue.size() == lengthOfQueue) {
                    try {
                        System.err.println(
                            "Producer " + id + " waits");
                        queue.wait();
                    } catch (InterruptedException ignore) {}
                }
                if (ProdCons.isDone) break;
                queue.addFirst(product);
                queue.notifyAll();
                System.err.println("Producer " + id +
                    " added  a product. Queue size is " +
                    queue.size());
                yield();
            }
        }
    }

    Object produce() {
        try {
            Thread.sleep((int)(901*Math.random()+100));
        } catch (InterruptedException ignore) { }
        return(new Object());
    }
}
