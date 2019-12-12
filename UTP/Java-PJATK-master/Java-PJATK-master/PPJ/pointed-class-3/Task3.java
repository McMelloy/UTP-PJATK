public class Task3{
    public static void main(String[] args){
        int[] arr = new int[20];
        int i;

        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*18);
            System.out.print(arr[i]+ " ");
        }

        int m = arr.length/2-1;
        System.out.println(m);
        for (int j = arr.length-1; j>m; j--){
            arr[j]= arr[j-1];
        }
        arr[m]=-1;
            for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }

}
}