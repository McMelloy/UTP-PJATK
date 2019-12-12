import java.util.Arrays;
public class InnerPart {
    // ...
    public static void main (String[] args) {
        int[][] a = { {1,2,3,4,5,6},
                      {2,3,4,5,6,7},
                      {3,4,5,6,7,8},
                      {4,5,6,7,8,9} };
        for (int[] r : a)
            System.out.println(Arrays.toString(r));
        System.out.println();
        for (int[] r : inner(a))
            System.out.println(Arrays.toString(r));
    }

    public static int[][] inner(int a[][]) {
        int[][] b = new int [a.length - 2][a[0].length -2];
        for (int i = 1; i < a.length - 1; i++) {
                for (int k = 1; k < a[i].length - 1; k++) {
                    b[i-1][k-1] = a[i][k];
                }
            }
        return b;
        }
    }
