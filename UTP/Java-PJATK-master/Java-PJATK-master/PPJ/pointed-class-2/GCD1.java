import java.util.Random;

public class GCD1{
    public static void main(String[] args){
        for (int i = 0; i<10; i++ ){
        Random r = new Random();
        int ranVal1 = r.nextInt(100);
        int ranVal2 = r.nextInt(100);
        int w = gcd(ranVal1, ranVal2);
       // System.out.println("ranVal1 " + ranVal1);
        //System.out.println("ranVal2 " + ranVal2);
        System.out.println(w);

        }
     }
     public static int gcd(int a, int b){
        int g = 0;
        int c;
        if (a==0){
            System.out.println("Error");
        }
        else{
        while(a>0){
            if (a==b){
            g=a;
                break;
        }
        else if (a<b){
            c=a;
            a=b;
            b=c;
        }
            else{
                a=a-b;
            }
            }
        }
        return g;
     }
}