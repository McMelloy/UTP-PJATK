/**
 * @author s19136
 * @group 18c
 * @blockchainHash 34d2b78c759899c802ced22a6af420999abf617918ffae6c20ad9c0db376f0a2
 */
public class Main {
    public static void main(String[] args) {
        char[] message = new char[]{'h', 'e', 'l', 'l', 'o'};

        if (contains(message, 'h')) {
            System.out.println("Array contains letter 'h'");
        }

        int X = 10, Y = 1;
        countUsingLoop(X, Y);
        countUsingRecursion(X, Y);

        int[][] arr = {
                {1,  2,  3,  4},
                {5,  6,  7},
                {9,  12},
                {13}
        };

        displayTwoDimensionalArray(arr);

        int[][] diagArr = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(
                sumOfElementsOnDiagonals(diagArr)
        );

    }

    static boolean contains(char[] message, char c){
        for(char i:message){
            if(i==c)
                return true;
        }
        return false;
    }

    static void countUsingLoop(int from, int till){
        if(from>till) {
            for (int i = from; i >= till; i--) {
                System.out.print(i + " ");
            }
        }
        else{
            for (int i = from; i <= till; i++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static void countUsingRecursion(int from, int till){
        if(from==till)
            System.out.println(from);
        else if(from>till){
            System.out.println(from--);
            countUsingRecursion(from, till);
        }
        else if(from<till){
            System.out.println(from++);
            countUsingRecursion(from, till);
        }
    }

    static void displayTwoDimensionalArray(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int sumOfElementsOnDiagonals(int[][]arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(i!=(arr.length-1-i))
                sum+=(arr[i][i]+arr[i][arr.length-1-i]);
            else
                sum+=arr[i][i];
        }
        return sum;
    }

}