// QKK-AuthorPublisher/Author.java
 
public class Author extends Thread {
    private final Buff buf;
    public Author(Buff b)  {
        buf = b;
    }

    @Override
    public void run() {
        String[] books =
            {
                "Macbeth", "Hamlet", "As You Like It",
                "King Lear", "Romeo and Juliet",
                "Othello", "Richard III", "Julius Caesar",
                "Winter's Tale", "Tempest", null
            };
        for (String book : books) {
            try {
                sleep((int)(Math.random()*2000)+200);
            } catch(InterruptedException ignore) { }
            buf.put(book);
        }
    }
}
