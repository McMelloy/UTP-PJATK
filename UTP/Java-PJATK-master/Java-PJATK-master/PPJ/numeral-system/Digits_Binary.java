import java.util.*;

public class Digits_Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rem = 0;
        while (num != 0) {
            rem = num % 2;
            num = (num - rem) / 2;
            if (num != 0) {
                System.out.print(rem + ", ");
            } else
                System.out.print(rem + " ");
        }
        sc.close();
    }
}