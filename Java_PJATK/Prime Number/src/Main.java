import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("This programm is written by Demetrius Baranowski");
        Scanner in = new Scanner(System.in);
        int num, numBuff;
        System.out.println("Input yo number");
        num=in.nextInt();numBuff=num;
        /////////////
        int sum=0;
        while((num/10)>=1){
            sum+=num%10;
            num/=10;
        }
        sum+=num;
        System.out.println("Sum of its digits is "+sum);
        /////////////
        String yes = "It is prime number";
        String no = "It is not a prime number";
        num=numBuff;
        if(num==1){
            System.out.println(no);
            return;
        }
        if(num==2){
            System.out.println(yes);
            return;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
                System.out.println(no);
                return;
            }
        }
        System.out.println(yes);
    }
}
