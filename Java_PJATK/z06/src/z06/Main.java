package z06;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Letter letters = new Letter("ABCD");
        for (Thread t : letters)
            System.out.println(t.getName() + " starting");
        letters.start();
        try { Thread.sleep(5000); }
        catch(InterruptedException ignore) { }
        letters.stop();
        System.out.println("\nProgram completed.");


    }
}
