public class Main {
    public static void main(String[] args) {
        int[] arr1 = {3, 6, 8, 2, 3, 1, 9};
        int[] arr2 = {6, 7, 3, 1};
        Array tmp = new Array(arr1);
        Array tmp2 = new Array(arr2);
        Array res = tmp.union(tmp2);
        res.print();
        //tmp.print();
    }

}
