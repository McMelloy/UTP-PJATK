public class Task_1 {
    public static void main(String[] args){
        {
            long before = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                System.out.print(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("\nthread main: " + (after - before));
        }


        Thread thread0 = new Thread(() -> {
            long before = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i += 2) {
                System.out.print(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("\nthread parzyste: " + (after - before));
        });
        Thread thread1 = new Thread(() -> {
            long before = System.currentTimeMillis();
            for (int i = 1; i < 1000000; i += 2) {
                System.out.print(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("\nthread nieparzyste: " + (after - before));
        });
        thread0.start();
        thread1.start();    
    }
}