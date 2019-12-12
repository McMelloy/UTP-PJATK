// QLB-ProdConsum/Consumer.java
 
import java.util.LinkedList;

class Consumer extends Thread {

    final LinkedList queue;
    final int id;

    Consumer(LinkedList q, int i) {
        queue = q;
        id    = i;
    }

    public void run() {
        while (true) {
            Object product = null;
            synchronized(queue) {
                if (   ProdCons.isDone
                    && queue.size() == 0 ) break;

                while (queue.size() == 0) {
                    try {
                        System.err.println(
                            "Consumer " + id + " waits");
                        queue.wait();
                    } catch (InterruptedException ignore) {}
                }
                product = queue.removeLast();
                queue.notifyAll();
                System.err.println("Consumer " + id +
                    " popped a product. Queue size is " +
                    queue.size());
            }
            consume(product);
            yield();
        }
    }

    void consume(Object obj) {
        try {
            Thread.sleep((int)(901*Math.random()+100));
        } catch (InterruptedException ignore) { }
    }
}
