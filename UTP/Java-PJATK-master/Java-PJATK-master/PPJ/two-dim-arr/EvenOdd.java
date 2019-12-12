public class EvenOdd{
    public static void main(String[] args) {
        int[][] arr = {
            { 1, 2, 3, 4, 5 },
            { 1, 9 },
            { 3, 1, 8 }
        };

        int[] oddEven = findOddEven(arr);
        System.out.println("Even: " + oddEven[0] + "; " + "Odd: " + oddEven[1]);
    }

    public static int[] findOddEven(int arr[][]) {
        int odd = 0;
        int even = 0;
        int[] oddEven = new int[2];
        for(int i = 0; i < arr.length; i++) {
            for(int k = 0; k < arr[i].length; k++){
                if (arr[i][k] % 2 != 0) {
                    odd++;
                } else {
                    even++;
                }
            }
        }
        oddEven[0] = even;
        oddEven[1] = odd;
        return oddEven;

    }

}