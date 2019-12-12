import java.util.Arrays;
import java.util.Random;
public class Task5{
    public static void main(String[] args){
        Random rand = new Random();
        int ran1 = rand.nextInt(20); 
        int[] arr = new int[ran1];

        for (int i = 0; i < arr.length; i++) {
            int ran2 = rand.nextInt(20); 
            arr[i] = ran2;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int ran3 = rand.nextInt(20); 
        int[] brr = new int[ran3];

        for (int i = 0; i < arr.length; i++) {
            int ran4 = rand.nextInt(20); 
            brr[i] = ran4;
            System.out.print(brr[i]+" ");
        }

        int [][]crr= new int[2][];
            
            crr[0] = arr;
            crr[1] = brr;

            System.out.println(Arrays.deepToString(crr));
    }
}