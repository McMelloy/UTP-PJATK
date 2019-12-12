/*
    print diagonals
*/
public class Task_4 {
    public static void main(String[] args) {
        int arr[][] =  {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int arr2[][] = {{1,2,3,4,5,6},{4,5,6,7,8,9},{7,8,9,10,11,12}};
        showDiagonals(arr);
    }

    public static void showDiagonals(int[][] a){
        System.out.print("first diagonal: ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i][i]);
            if(i == a.length-1) {
                System.out.print(".");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("second diagonal: ");
        int i = 0;
        for(int j = a.length-1; j >= 0; j--) {
            System.out.print(a[i][j]);
            if(i == a.length-1) {
                System.out.print(".");
            } else {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println();
    }

    public static void showEdges(int[][] a) {
        
    }
}