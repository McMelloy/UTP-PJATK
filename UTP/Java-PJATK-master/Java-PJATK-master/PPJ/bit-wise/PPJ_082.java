
import java.util.Scanner;

public class PPJ_082 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // part 1
        int n = in.nextInt();

        int mask = 1;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (mask << i)) != 0)
                count++;
        }
        System.out.println(count);

        // part 2
        if ((n & 0b1000000) != 0)
            System.out.println("Set");

        // part 3
        count = -1;
        for (int i = 0; i < 32; i++) {
            if ((n & (mask << i)) != 0)
                count = i;
        }
        System.out.println(count);

        // part4

        int x = n;
        System.out.println("ARGB: " + Integer.toBinaryString(x));
        int x1 = x << 16;
        x1 = x1 >>> 16;// 00GB

        x1 = ~x1;// reverse 11GB

        x1 = x1 << 16;
        x1 = x1 >>> 16; // 00 reverse GB

        x = x >>> 16;
        x = x << 16; // AR00
        int x2 = x + x1;
        System.out.println("ARGB: " + Integer.toBinaryString(x2));
        sc.close();
    }

}