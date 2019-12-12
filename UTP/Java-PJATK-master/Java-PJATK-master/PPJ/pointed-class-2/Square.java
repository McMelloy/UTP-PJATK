import java.util.Scanner;
public class Square {
    public static void main (String[] args){
        square();
    }
    public static void square(){
        Scanner sc = new Scanner(System.in);
        String ch1 = sc.next();
        String ch2 = "*";
        int size = sc.nextInt();
        for (int k = 0; k < size; k++){
            for ( int i=0; i< size; i++){
                System.out.print(ch1);
                if (ch1.equals(ch2)){
                    ch1 = "o";
                }else ch1 = "*";
            }
            System.out.println();
        }
    }
}