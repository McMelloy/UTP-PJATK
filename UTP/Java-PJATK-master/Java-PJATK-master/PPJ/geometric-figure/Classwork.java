import java.util.*;

public class Classwork {
    static void print(Object obj) {
    System.out.print(obj);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        print("Enter a width: ");
        int width = scan.nextInt();
        print("Enter a height: ");
        int hight = scan.nextInt();
        for (int k = width;k > 0; k--) {
            print("*");
        }
        print("\n");
       
            for (int m = (hight-2);m > 0; m-- ) {
            print("*");
            for (int j = (width-2); j > 0; j--) {
                print(" ");
            }
            print("*\n");
        }
        
        for (int k = width;k > 0; k--) {
            print("*");
        }
        //print("\n");
        scan.close();
    }
}