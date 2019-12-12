// QKK-AuthorPublisher/Publisher.java
 
public class Publisher extends Thread {
    private final Buff buf;
    public Publisher(Buff b) {
        buf = b;
    }

    @Override
    public void run() {
        String book = buf.take();
        while(book != null) {
            try {
                sleep((int)(Math.random()*2500)+200);
            } catch(InterruptedException ignore) { }
            book = buf.take();
        }
    }
}
