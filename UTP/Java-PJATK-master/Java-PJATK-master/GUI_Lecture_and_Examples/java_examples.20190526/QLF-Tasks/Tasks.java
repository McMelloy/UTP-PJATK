// QLF-Tasks/Tasks.java
 
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Tasks {
    public static void main(String[] args) {
        FutureTask<Long>[] fs = new MyFutureTask[]{
                new MyFutureTask(new CallableFibo(43)),
                new MyFutureTask(new CallableFibo(45)),
                new MyFutureTask(new CallableFibo(-2)),
                new MyFutureTask(new CallableFibo(47))
            };
        ExecutorService ex =
                Executors.newFixedThreadPool(2);
        for (FutureTask<Long> t : fs) ex.submit(t);
        ex.shutdown();
        try {
            boolean term =
                ex.awaitTermination(10,TimeUnit.SECONDS);
            if (term)
                System.err.println( "All tasks completed");
            else
                System.err.println(
                    "Timeout: some tasks still running");
        } catch(InterruptedException e) {
            System.err.println("Main thread interrupted");
        }
    }
}

class MyFutureTask extends FutureTask<Long> {
    public MyFutureTask(Callable<Long> c) {
        super(c);
    }
    public void done() {
        String mes = "";
          // isDone must be true
        if (isDone()) mes += "DONE. ";
        if (isCancelled()) mes += "Cancelled.";
        else
            try {
                mes += ("Result OK: " + get());
            } catch(Exception e) {
                mes += ("Exception: " + e.toString());
            }
        System.err.println(mes);
    }
};

class CallableFibo implements Callable<Long> {
    long arg;
    public CallableFibo(long arg) {
        this.arg = arg;
    }
    public Long call() throws Exception {
        return fibo(arg);
    }
    private long fibo(long n) {
        if (n < 0)
            throw new IllegalArgumentException("From fibo");
        if (n <= 1) return n;
        return fibo(n-1)+fibo(n-2);
    }
}
