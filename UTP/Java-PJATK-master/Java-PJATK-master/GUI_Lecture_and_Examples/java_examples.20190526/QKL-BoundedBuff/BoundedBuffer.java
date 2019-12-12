// QKL-BoundedBuff/BoundedBuffer.java
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final int MAXBOOKS;
    private final String[] books;
    private final Lock lock = new ReentrantLock();
    private final Condition full  = lock.newCondition();
    private final Condition empty = lock.newCondition();

    private int posIn = 0, posOut = 0, count = 0;

    public BoundedBuffer(int mx) {
        MAXBOOKS = mx;
        books = new String[MAXBOOKS];
    }

    public void put(String book) {
        lock.lock();
        try {
            while (count == MAXBOOKS)
                full.await();
            books[posIn] = book;
            posIn = (posIn + 1) % MAXBOOKS;
            ++count;
            System.out.println("put : count = " + count +
                               " '" + book + "'");
            empty.signal();
        } catch(InterruptedException e) {
            throw new IllegalStateException();
        } finally {
            lock.unlock();
        }
    }

    public String take() {
        lock.lock();
        try {
            while (count == 0)
                empty.await();
            String book = books[posOut];
            posOut = (posOut + 1) % MAXBOOKS;
            --count;
            System.out.println("take: count = " + count +
                               " '" + book + "'");
            full.signal();
            return book;
        } catch(InterruptedException e) {
            throw new IllegalStateException();
        } finally {
            lock.unlock();
        }
    }
}
