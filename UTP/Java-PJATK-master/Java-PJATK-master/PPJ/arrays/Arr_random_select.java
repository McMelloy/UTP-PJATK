public class Arr_random_select{
    public static void main (String[] args){
        int[] arr = new int[10];
        int i;
        int n = 1;
        for (i = 0; i < 10; i++ , n++ ) { //put values from 1 to 10 the the array 
            arr[i] = n;

            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int s1 = (int)(Math.random()*arr.length); // crate a random value with index
        int s2 = (int)(Math.random()*arr.length); 
        int temp = arr[s1];
        arr[s1]= arr[s2];
        arr[s2] = temp;
        int k; // change values with random indexes
        for (k=0; k< arr.length; k++){
            System.out.print(arr[k]+" ");
        } // print array 
    }
}