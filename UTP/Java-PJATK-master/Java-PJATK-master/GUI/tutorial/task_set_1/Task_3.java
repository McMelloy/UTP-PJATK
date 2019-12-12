import java.util.Random;
/*
print two dimensial array

*/
public class Task_3{
    public static void main (String[] args) {
        Random rand = new Random();
        int[][] arr = new int[5][rand.nextInt((5 - 3) + 1) + 3];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rand.nextInt((20 - 0) + 1);
            }
        }
        print(arr);
    }

    public static void print(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
