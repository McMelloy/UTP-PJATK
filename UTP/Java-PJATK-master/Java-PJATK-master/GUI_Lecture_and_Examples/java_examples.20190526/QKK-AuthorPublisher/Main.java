// QKK-AuthorPublisher/Main.java
 
public class Main {
    public static void main(String[] args) {
        Buff buf = new Buff();
        new Author(buf).start();
        new Publisher(buf).start();
    }
}
