public class StatFuns {
    static int maxOfThree(int a, int b, int c) {
        int max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        return max;
    }

    static int greatestDivisor(int n) {
        int max=0;
        int pr=2;
        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                max = i;
            } else
                pr++;
        }
        if (pr == n) {
            max = 1;
        }
        return max;
    }

    static boolean areRelativelyPrime(int a, int b) {
        boolean rp = false;
        int max;
        int count=0;
        if (a >= b) {
            max = a;
        } else {
            max = b;
        }
        for (int i = 2; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            rp = true;
        }
        return rp;
    }

    static boolean isPerfect(int n) {
        boolean p = false;
        int sum=0;
        for(int i = 1; i<n; i++){

            if(n % i == 0){
                sum +=i;
            }
        }
        if (sum == n){
            p = true;
        }
        return p;
    }

    public static void main(String[] args) {
        int x = 2, y = 3, z = 1;
        System.out.println("Max of " + x + ", " + y + ", " + z + " is " + maxOfThree(x, y, z));

        for (int a = 12; a < 16; ++a)
            System.out.println("Greatest divisor of " + a + " is " + greatestDivisor(a));

        for (int m = 11, n = 5; m >= 3; m -= 2, n += 2)
            if (areRelativelyPrime(m, n))
                System.out.println(m + " and " + n + " are relatively prime");

        for (int m = 2; m <= 100; ++m)
            if (isPerfect(m))
                System.out.println(m + " is perfect");
    }
}