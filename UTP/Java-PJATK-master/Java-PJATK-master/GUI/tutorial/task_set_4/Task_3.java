class AddingThread extends Thread {

    private Counter c;

    public AddingThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            c.inc(i);
        }
    }
}

class Counter {
    private int x = 0;
    void inc(int value) {
        synchronized (this) {
            int sum = x + value;
            x = sum;
        }
    }
    public String toString() {
        return x + "";
    }
}

public class Task_3 {

    public static void main(String[] args) {
        Counter c = new Counter();
        AddingThread at0 = new AddingThread(c);
        at0.start();
        AddingThread at1 = new AddingThread(c);
        at1.start();
        AddingThread at2 = new AddingThread(c);
        at2.start();
        System.out.println("Counter.x=" + c);
    }
}