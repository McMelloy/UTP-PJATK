import java.util.*;
public class OddEven {
    //check if the value is odd or even 
    //flip the fisrt odd with last even
    public static void main(String[] args) {

        Random rnd = new Random();
        int ranVal1 = rnd.nextInt(20);
        int[] arr = new int[ranVal1];
        for (int i = 0; i < arr.length; i++) {
            int ranVal2 = rnd.nextInt();
            arr[i] = Math.abs(ranVal2);
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
        System.out.println();

        int odd = 0;
        int l = 0;
        int even = 0;
        int f = 0;
        for (int r = 0; r < arr.length; r++) {
            if (arr[r] % 2 == 1) {
                odd = arr[r];
                l = r;
               break;
            }
        }
        for (int w = 0; w < arr.length; w++) {
            if (arr[w] % 2 == 0) {
                even = arr[w];
                f = w;
            }
        }
        if (even == 0) {
            System.out.println("They are all odd");
        } else if (odd == 0) {
            System.out.println("They are all even");
        } else {
            int temp = arr[l];
            arr[l] = arr[f];
            arr[f] = temp;
            for (int k = 0; k < arr.length; k++) {
                System.out.println(arr[k]);
            }
         }
     }
}