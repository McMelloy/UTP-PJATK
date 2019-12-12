// QKL-BoundedBuff/Publisher.java
 
public class Publisher extends Thread {
    private final BoundedBuffer buf;
    public Publisher(BoundedBuffer b) {
        buf=b;
    }

    @Override
    public void run() {
        String book = buf.take();
        do {
            try {
                Thread.sleep((int)(Math.random()*2000)+500);
            } catch(InterruptedException ignored) { }
            book = buf.take();
        } while(book != null);
    }
}
