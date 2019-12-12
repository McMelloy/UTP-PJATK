public class Flip_arr {
    //flip array
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int i;
        int a;
        a = arr[0];
        arr[0] = arr[1];
        arr[1] = a;
        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}