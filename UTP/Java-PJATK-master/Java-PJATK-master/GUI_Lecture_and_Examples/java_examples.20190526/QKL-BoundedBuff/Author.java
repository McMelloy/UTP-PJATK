// QKL-BoundedBuff/Author.java
 
public class Author extends Thread {
    private final BoundedBuffer buf;
    public Author(BoundedBuffer b)  {
        buf = b;
    }

    @Override
    public void run() {
        String[] books =
            {
                "Macbeth", "Hamlet", "As You Like It",
                "King Lear", "Romeo and Juliet",
                "Othello", "Richard III", "Julius Caesar",
                "Winter's Tale", "Tempest",
                null
            };
        for (String book : books) {
            try {
                Thread.sleep((int)(Math.random()*1000)+300);
            } catch(InterruptedException ignore) { }
            buf.put(book);
        }
    }
}
