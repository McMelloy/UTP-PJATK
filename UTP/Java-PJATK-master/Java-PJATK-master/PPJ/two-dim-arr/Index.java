public class Index {
    public static void main(String[] args) {
        int[][] arr = {
            { 1, 3, 2 },
            { 3, 4, 8 },
            { 2, 6, 8 },
            { 1, 8, 5 }
        };
        index(arr);
    }

    public static void index (int[][] arr){
        int row = 0;
        int col = 0;
        int mid = 0;
        int temp=0;
        int i = 0;
        int index = 0;
        int column = 0;

        for (i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                mid += arr[i][k];
              //  System.out.println("mid" + mid);
            }
            if (mid > row) {
                row = mid;
                index = i;
            }
            //System.out.println(index);
            mid = 0;
        }

        for (i = 0; i < arr[i].length; i++) {
            for (int k = 0; k < arr.length; k++) {
                temp+= arr[k][i];
              //  System.out.println("mid" + mid);
            }
            if (temp >col ) {
                col = temp;
                column = i;
            }

            temp = 0;

        }
        System.out.println("column " + column);
        System.out.println("row " + index);
    }
}
