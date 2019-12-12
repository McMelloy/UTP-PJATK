import java.util.Arrays;
import java.util.Random;


/* Random array with two methods:
    even numbers and  odd indexes 
clea*/


public class Task_2{
    public static void main(String[] args){
        int[] arr = new int[10];
        Random rand = new Random();
        for(int i = 0; i < arr.length ; i++) {
            arr[i] = rand.nextInt(11 - 3) + 3;
        }
        evenNumbers(arr);
        oddIndexes(arr);
    }

    public static void evenNumbers(int[] arr) {
        for (int a : arr) {
            if(a % 2 == 0){
                System.out.print(a + ", ");
            }
        }
    }

    public static void oddIndexes(int[] arr) {
        System.out.println("check: "+ Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 != 0) {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}