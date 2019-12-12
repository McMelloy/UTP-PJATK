// QKK-AuthorPublisher/Buff.java
 
public class Buff {
    private String         book =  null;
    private boolean isBookReady = false;

      // new book from author - called by author
    synchronized public void put(String b) {
        while (isBookReady) {
            try {
                wait(); // on 'this'
            } catch(InterruptedException ignored) { }
        }
        book        = b;
        System.out.println("put : " + book);
        isBookReady = true;
        notify();
    }

      // get book and publish it - called by publisher
    synchronized public String take() {
        while (!isBookReady) {
            try {
                wait(); // on this
            } catch(InterruptedException exc) {}
        }
        isBookReady = false;
        System.out.println("take: " + book);
        notify();
        return book;
    }
}
