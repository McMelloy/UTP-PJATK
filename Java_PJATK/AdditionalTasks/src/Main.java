import java.util.*;

class Rectangle{
    private int a, b, area;
    private double diagonal;
    Rectangle(){
        a=b=area=0;
        diagonal=0;
        readData();
    }
    void readData(){
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        area = a*b;
        diagonal=Math.sqrt(a*a+b*b);
    }
    int calculateArea(){
        area = a*b;
        return area;
    }
    double calculateDiagonal(){
        diagonal = Math.sqrt(a*a+b*b);
        return diagonal;
    }
    @Override
    public String toString(){
        String str = "a = "+a+", b = "+b;
        str = str.concat("Area = "+area);
        str = str.concat("Diagonal = "+diagonal);
        return str;
    }
}
class Sort{
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    void insertSort(int[]a){
        for(int i=1;i<a.length;i++){
            int j=i;
            while(j>0 && a[j-1]>a[j]){
                swap(a,j,j-1);
                j--;
            }
        }
    }
    void selectionSort(int[]a){
        for(int i=0;i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min])
                    min=j;
            }
            swap(a,i,min);
        }
    }
    void mergeSort(int[] a, int l, int r) {
        int split;                   // индекс, по которому делим массив

        if (l < r) {                // если есть более 1 элемента

            split = (l + r)/2;

            mergeSort(a, l, split);       // сортировать левую половину
            mergeSort(a, split+1, r);// сортировать правую половину
            merge(a, l, split, r);    // слить результаты в общий массив
        }
    }
    void merge(int a[], int l, int split, int r) {
// Слияние упорядоченных частей массива в буфер temp
// с дальнейшим переносом содержимого temp в a[l]...a[r]

        // текущая позиция чтения из первой последовательности a[l]...a[split]
        int pos1=l;

        // текущая позиция чтения из второй последовательности a[split+1]...a[r]
        int pos2=split+1;

        // текущая позиция записи в temp
        int pos3=0;

        int[] temp = new int[r-l+1];

        // идет слияние, пока есть хоть один элемент в каждой последовательности
        while (pos1 <= split && pos2 <= r) {
            if (a[pos1] < a[pos2])
                temp[pos3++] = a[pos1++];
            else
                temp[pos3++] = a[pos2++];
        }

        // одна последовательность закончилась - 
        // копировать остаток другой в конец буфера 
        while (pos2 <= r)   // пока вторая последовательность непуста 
            temp[pos3++] = a[pos2++];
        while (pos1 <= split)  // пока первая последовательность непуста
            temp[pos3++] = a[pos1++];

        // скопировать буфер temp в a[l]...a[r]
        for (pos3 = 0; pos3 < r-l+1; pos3++)
            a[l+pos3] = temp[pos3];
    }
    void print(int[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]);
        System.out.println();
    }
}
public class Main {
    static void showBetween(char a, char b){
        char tmp = (char)(a+1);
        while(tmp!=b){
            System.out.println(tmp);
        }
    }
    static int countOdd(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0)
                count++;
        }
        return count;
    }
    static void reverse(int[][] arr){
        for(int i=0; i<=arr.length;i++){
            for(int j=0;j<=(arr[i].length/2);j++){
                int tmp = arr[i][j];
                arr[i][j]=arr[i][arr[i].length-1-j];
                arr[i][arr[i].length-1-j]=tmp;
            }
        }
    }
    static int sum(int n){
        if(n==0)
            return n;
        else
            return n+sum(n-1);
    }
    public static void main(String[] args) {
	// write your code here
    }
}
