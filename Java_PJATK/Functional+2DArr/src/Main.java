

class TicTacToe{
    char[][] field;
    char next;
    java.util.Scanner in = new java.util.Scanner(System.in);
    TicTacToe(){
        field = new char[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                field[i][j] = 'N';
        next = 'X';
        nextMove();
    }


    private void nextMove(){
        while(!endGame() && !allFieldTaken()) {
            System.out.println("Player " + next + ", your move! Type index: ");
            int a = in.nextInt();
            int b = in.nextInt();
            while (!checkPossibilityOfMove(a, b)) {
                System.out.println("Looks like you can't move here");
                a = in.nextInt();
                b = in.nextInt();
            }
            field[a][b] = next;
            print();
            if(!endGame() && !allFieldTaken()) {
                if (next == 'O')
                    next = 'X';
                else
                    next = 'O';
            }
        }
        if(endGame())
            System.out.println(next+", you are a winner!");
        else
            System.out.println("Guys, you're out of moves");
    }
    private boolean checkPossibilityOfMove(int a, int b){
        if(a>2 || b>2)
            return false;
        else if(field[a][b]!='N')
            return false;
        return true;
    }
    private void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++)
                System.out.print(field[i][j]+"|");
            System.out.println(field[i][2]);
            for(int j=0;j<3;j++)
                System.out.print("-");
            System.out.println();
        }
    }
    private boolean endGame(){
        for(int i=0;i<3;i++) {
            if ((field[i][0] == field[i][1] && field[i][1] == field[i][2]) && (field[i][2] == 'O' || field[i][2] == 'X'))
                return true;
            if ((field[0][i] == field[1][i] && field[1][i] == field[2][i]) && (field[2][i] == 'O' || field[2][i] == 'X'))
                return true;
        }
        if ((field[0][0] == field[1][1] && field[1][1] == field[2][2]) && (field[2][2] == 'O' || field[2][2] == 'X'))
            return true;
        if ((field[2][0] == field[1][1] && field[1][1] == field[0][2]) && (field[0][2] == 'O' || field[0][2] == 'X'))
            return true;
        return false;
    }
    private boolean allFieldTaken(){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(field[i][j]=='N')
                    return false;
        return true;
    }

}
public class Main {
    static int factorial(int n){
        if(n==1)
            return 1;
        else
            return n*factorial(n-1);
    }
    static int fibonacci(int n){
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    static int[][] generate2DArray(int size){
        int[][] res = new int[size][size];
        for(int i=0;i<res.length;i++)
            for(int j=0;j<res[0].length;j++)
                res[i][j]=(int)(Math.random()*100);
        return res;
    }
    static void print2DArray(int[][]arr){
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    static void printDiagonals(int[][]arr){
        for(int k=0;k<arr.length;k++){
            int i=k;
            int j=0;
            while(i>=0 && j<arr[0].length){
                System.out.print(arr[i][j]+" ");
                i--;j++;
            }
            System.out.println();
        }
        for(int k=1;k<arr[0].length;k++){
            int i = arr.length-1;
            int j = k;
            while(i>=0 && j<arr[0].length){
                System.out.print(arr[i][j]+" ");
                i--;j++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe();
    }
}
