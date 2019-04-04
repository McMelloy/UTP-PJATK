class Task implements Runnable{
    private char chr;
    private final static Object microfone = new Object();

    public Task(char chr){
        this.chr = chr;
    }

    @Override
    public void run() {
        for(int i =0; i<10; i++) {
            System.out.print(chr);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        new Thread(
            new Task('a')
        ).start();
        new Thread(
                new Task('b')
        ).start();
        new Thread(
                new Task('c')
        ).start();
    }
}
