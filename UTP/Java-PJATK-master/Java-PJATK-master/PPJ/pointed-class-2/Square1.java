import java.util.Scanner;
public class Square1 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String ch1 = sc.next();
        int size = sc.nextInt();
        square(ch1, size);
    }
    public static void square(String a, int b){
        String ch2 = "*";
        for (int k = 0; k < b; k++) {
            for ( int i = 0; i< b; i++) {
                System.out.print(a);
                if (a.equals(ch2)) {
                    a = "o";
                } else a = "*";
            }
            System.out.println();
        }
    }
}