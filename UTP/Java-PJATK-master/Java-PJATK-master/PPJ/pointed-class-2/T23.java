import java.lang.Math;
import java.util.Scanner;
public class T23{
    /*
    public static double find(int f ,int g, int k){
        double s;
        s = ( (1/2) * (f + g + k) );
        System.out.print(s);
        double area = Math.sqrt( s*(s-f)*(s-g)*(s-k) );
        return area;
    }*/
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double s;
        s = ( (a + b + c)/2 );
        System.out.print(s);
        double area = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
        
    }
}