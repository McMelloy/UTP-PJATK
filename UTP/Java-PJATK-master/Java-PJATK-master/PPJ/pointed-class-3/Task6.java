import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        int [][] arr = new int[8][8];
        Random rand = new Random();

        for(int[] a : arr){
            for(int i = 0; i < arr.length; i++) {
                a[i] = rand.nextInt(11);
            }
        }
        System.out.println("Array:");
        for( int[] a : arr) {  
            System.out.println(Arrays.toString(a));
        }
        
        int[] brr = new int[arr.length];
        int[] crr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            brr[i] = arr[i][i];
            crr[i] = arr[i][arr[i].length - i - 1];
        }
        
        //int [] nrr = {5,5,5,2,4,5,6,6,6};
        System.out.println("First diagonal:");
        getDuplicates(brr);
        System.out.println("Second diagonal:");
        getDuplicates(crr);
    }

    private static void getDuplicates(int[] a) {
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        //[1, 3, 3, 7, 7, 7, 7, 8, 10]
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(i > 0) {
                if(a[i] == a[i-1]) {
                    count++;    
                } else {
                    if(count >= 3) {
                        System.out.println(a[i-1]);
                    }
                    count = 1;
                }
            } else {
                count = 1;
            }
            //System.out.println("Count: " + count); 
        }
        if(count >= 3) {
            System.out.println(a[a.length - 1]);
        }
        System.out.println();
    } 
}