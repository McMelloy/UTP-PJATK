import java.awt.*;

class MyTask extends Thread{
    private char chr;
    private Thread next;

    public MyTask(char chr) {
        this.chr = chr;
        start();
    }

    public void setNext(Thread next){
        this.next = next;
    }
    public void run(){
        try{
            for(int i=0;i<100;i++){
                synchronized (this) {
                    this.wait();
                }
                System.out.println(chr);
                synchronized (next) {
                    next.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Main {
    public static void main(String[] args) {
	// write your code here
        Frame f = new Frame();
        f.setVisible(true);
    }
}
