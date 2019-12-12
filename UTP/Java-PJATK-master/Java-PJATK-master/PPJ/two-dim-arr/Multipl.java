import java.util.Arrays;
import java.util.*;
public class Multipl{
    public static void main(String[] args){
        int [][] a = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        int [][] b = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        };

        int[][] res = new int[a.length][a[0].length];

        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[0].length; j++){
                int sum = 0; 
                int temp = 0;
                for( int k = 0; k< b[0].length; k++){
                    temp = a[j][k]*b[k][i];
                    sum +=temp;
                    res[j][i] = sum;
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
    } 
}