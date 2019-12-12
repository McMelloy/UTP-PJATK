// QKL-BoundedBuff/Main.java
 
public class Main {
    public static void main(String[] args) {
        BoundedBuffer buf = new BoundedBuffer(3);
        new Author(buf).start();
        new Publisher(buf).start();
    }
}
