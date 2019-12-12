public class Task_2{
    public static void main(String[]args) {
        Thread thread0 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(j);
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.err.print(j);
                    }
                }
            }
        });

        thread0.start();
        thread1.start();
    }


}