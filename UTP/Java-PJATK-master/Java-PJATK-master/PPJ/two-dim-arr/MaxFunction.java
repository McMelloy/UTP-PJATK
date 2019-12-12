public class MaxFunction {
    public static void main(String[] args) {
        int[][] arr = {
            { 1, 3 },
            { 3, 4, 5, 8 },
            { 6, 8 },
            { 1, 9, 6 }
        };
        int[] res = findLargest(arr);
        System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            if (i < res.length - 1) {
                System.out.print(res[i] + ", ");
            } else {
                System.out.print(res[i]);
            }
        }
    }

    public static int[] findLargest(int arr[][]) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                int max = arr[i][0];
                for (int k = 1; k < arr[i].length; k++) {
                    if (arr[i][k] > max) {
                        max = arr[i][k];
                    }
                }
                res[i] = max;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}