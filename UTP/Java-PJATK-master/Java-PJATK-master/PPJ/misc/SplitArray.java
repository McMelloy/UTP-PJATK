import java.util.Arrays;
public class SplitArray{
    public static void main(String[] args){
        int[] arr = new int[100];
        for (int x = 0; x< arr.length;x++){
            arr[x] = (int)(Math.random()*100);
        }
       split(arr);
       System.out.println("first" + (Arrays.toString(arr)));
    }
      /*  for(int k = 0; k < 2; k++){
            split(arr, arr.length/2);
            }
        System.out.println(Arrays.toString(split(arr, arr.length/2)));
        System.out.println(Arrays.toString(arr));
    }*/
    public static int[][](int )

    public static void sort(int arr[][], int a, int b) {
        if (a < b ){
            if( arr[a] > arr[a+1]) {
                int temp;
                temp = arr[a];
                arr[a] = arr[a+1];
                arr[a+1] = temp;
            }
        } else {
                merge();
            }
        }
    
    public static int[][] split(int[] arr) {
    
        if(arr.length % 2 == 0){
            //100/2 = 50 
            //int i = (arr.length/2)-1;
            //new arr length 50 -> 0-49
            int[] brr = new int[arr.length/2];
            for(int j = 0; j < brr.length; j++) {
                brr[j]= arr[j];
            }
            int[] crr = new int[arr.length/2];
            for(int h = 0; h < crr.length; h++) {
                crr[h] = arr[h + (arr.length/2)];
            }
            if(arr.length <= 4){
                int[][] drr = new int[brr.length][crr.length];
                sort(drr, 0, brr.length - 1);
            }
            //System.out.println(Arrays.toString(brr));
            //System.out.println(Arrays.toString(crr));
        }
        else if (arr.length % 2 != 0) {
            //101 % 2 != 0
            //int k = ((arr.length-1)/2)-1;
            // new arr len 101-1/2 = 50+1 -> 0-50
            int[] brr = new int[(arr.length-1)/2];
            for(int j = 0; j < brr.length; j++) {
                brr[j]= arr[j];
            }
            int[] crr = new int[(arr.length/2)+1];
            for(int h= 0; h < crr.length; h++) {
                crr[h] = arr[h+((arr.length+1)/2)];
            }
            System.out.println(Arrays.toString(brr));
            System.out.println(Arrays.toString(crr));
        }
        return arr;
    }
}