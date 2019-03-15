import java.util.*;
import java.lang.*;
public class Windows {
    public static void main(String[] args) {
        System.out.println("Input n");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.printf("%4d",(i*j));
            }
            System.out.println();
        }

    }
}
