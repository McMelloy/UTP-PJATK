import java.util.*;
public class CloseToZero{
    //sum of two min values in random array
    public static void main(String[] args){

        Random rnd = new Random();
         int ranVal2 = rnd.nextInt(20);
         int[] arr = new int[ranVal2];

       for (int i = 0; i < arr.length; i++) { //put random values
            int ranVal1 = rnd.nextInt(20);
            arr[i] = Math.abs(ranVal1);
        }

        for (int k = 0; k < arr.length; k++) { // print array
            System.out.print(arr[k]+" ");
        }
        System.out.println();

        int min1 = arr[0];
        for (int h=0; h<arr.length; h++){  //find min1
            if(arr[h]<=min1){
                min1 = arr[h];
            }
        }
         System.out.println(min1);

         int min2 = arr[0];

        for (int h=0; h<arr.length; h++){  //find min2
            if (arr[h] > min1) {
                min2 = (min2 > arr[h])? arr[h]:min2;
                }
            }

        System.out.println(min2);
        System.out.println(min1+min2);
        }



    }
