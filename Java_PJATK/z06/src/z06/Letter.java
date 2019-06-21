package z06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Letter implements Iterable<Thread>{
    List<Thread> list = new ArrayList<>();
    volatile boolean go = true;

    public Letter(String str){
        char[] arr = str.toCharArray();
        for(char c: arr){
            Thread t = new Thread(()->{
                while(go) {
                    System.out.print(c);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(t);
        }
    }
    void start() {
        for(Thread t: list)
            t.start();
    }

    void stop() {
        go = false;
    }
    @Override
    public Iterator<Thread> iterator() {
        return list.iterator();
    }
}

