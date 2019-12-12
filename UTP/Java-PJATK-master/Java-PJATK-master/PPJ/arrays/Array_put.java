import java.util.Random;

public class Array_put {
    public static void main(String[] args) {
        Random rand = new Random();
        int ran1 = rand.nextInt(); 
        ran1 = Math.abs(ran1);
        int[] arr = new int[ran1]; // create an array with random length
        
        for (i = 0; i < arr.length; i++) {
            int ran2 = rand.nextInt(); 
            arr[i] = ran2;
            System.out.println(arr[i]);
        }

    }
}