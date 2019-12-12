public class Rot{
    //shift array to the left
    public static void main(String[] args){
        int[] arr = { 2, 7, 3, 9, 5 ,6,3};
        //int last = arr[0];
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
        System.out.println();
        int temp=0;
        for (int i = 0; i<arr.length-1; i++){
            temp = arr[i];
            //System.out.println("temp "+temp);
            arr[i]= arr[i+1];
            //System.out.println("arr[i] "+arr[i]);
            arr[i+1]= temp;
            //System.out.println("arr[i+1] "+arr[i+1]);

        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }

    }
}