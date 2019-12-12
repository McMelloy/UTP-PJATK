public class AstArr {
    //print astr according to values in array
    public static void main(String[] args) {
        int[] arr = { 1, 100, 8, 99 };
        int max = 0;
        max = arr[0];
        for (int m = 0; m < arr.length; m++) {
            System.out.println("max " + max);
            max = (arr[m] > max) ? arr[m] : max;
        }
        System.out.println(max);
        for (int i = max; i > 0; i--) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] < max) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            max--;
            System.out.println();
        }

    }
}