// QLD-ConcMap/ConcMap.java
 
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcMap {
    private final static int numThreads = 500;
    private static Set<Thread> allThreads = new HashSet<>();

    public static void main (String[] args) {
          // variables 'rand' and 'map' effectively final
        Random rand = new Random();
        ConcurrentMap<Integer,String>
                map = new ConcurrentHashMap<>();

          // launching numThreads threads operating
          // on the same map (can take a while...)
        System.out.printf("Launching %d threads. Wait... ",
                           numThreads);
        for (int i = 1; i <= numThreads; ++i) {
            String tName = String.format("T_%03d",i);
            Thread thread = new Thread(
                () -> {
                    while (!Thread.interrupted()) {
                        map.put(rand.nextInt(10)+1,
                                tName);
                    }
                }
            );
              // storing threads to interrupt them later
            allThreads.add(thread);
              // launch this thread
            thread.start();
        }
        System.out.println("Threads running.");
        whatsUp(map); // whatsUp iterates over 'hot' map
        sleep(2000);
        whatsUp(map); // and again

          // killing all threads
        allThreads.stream().forEach(t -> t.interrupt());
    }

    private static void whatsUp(
                ConcurrentMap<Integer,String> map) {
        System.out.println("Iterating over hot map");
        map.entrySet().stream().forEach(
            e -> {
                System.out.println(
                    String.format( "%02d -> %s",
                        e.getKey(), e.getValue()
                    )
                );
            }
        );
    }

    private static void sleep(long time) {
        try { Thread.sleep(time); }
        catch (InterruptedException e) {
            System.out.println("Should not happen...");
            System.exit(1);
        }
    }
}
