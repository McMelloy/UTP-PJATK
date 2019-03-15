/**
 * @author s19136
 * @group 18c
 * @blockchainHash 34d2b78c759899c802ced22a6af420999abf617918ffae6c20ad9c0db376f0a2
 */
public class Main {


    public static void main(String[] args) {

        int arraySize = 100;

        int[] model = generateRandomArray(arraySize);

        int[] clone = copyArray(model);
        if (areArraysEqual(model, clone))
            System.out.println("I score 1 point");
        else
            System.out.println("Something is wrong");

        int[] merged = mergeTwoArrays(model, clone);
        if (merged.length == arraySize*2)
            System.out.println("I score 1 point");
        else
            System.out.println("Something is wrong");


        char from = 'a';
        char to = 'z';
        char[] message = generateRandomMessage(arraySize, from, to);

        char[] encrypted = encrypt(message);
        System.out.print("Encrypted: ");
        printArray(encrypted);

        char[] decrypted = decrypt(message);
        System.out.print("Decrypted: ");
        printArray(decrypted);

        if (areArraysEqual(message, decrypted))
            System.out.println("Maybe I score 3 points");
        else
            System.out.println("Maybe I score 0, 1, 2 points...");

    }

    public static int[] generateRandomArray(int size){
        int[] res = new int[size];
        for(int i=0;i<res.length;i++){
            res[i]=(int)(Math.random()*100);
        }
        return res;
    }
    public static int[] copyArray(int[] arr){
        int[] res = new int[arr.length];
        for(int i=0;i<res.length;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public static boolean areArraysEqual(int[] arr1,int[] arr2){
        boolean equal=true;
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
    public static boolean areArraysEqual(char[] arr1,char[] arr2){
        boolean equal=true;
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
    public static int[] mergeTwoArrays(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        for(int i=0;i<arr1.length;i++){
            res[i]=arr1[i];
        }
        for(int i=0;i<arr2.length;i++){
            res[arr1.length+i]=arr2[i];
        }
        return res;
    }
    public static char[] generateRandomMessage(int size, char from, char to){
        char[] res = new char[size];
        for(int i=0;i<res.length;i++){
            int from1=(int)from;
            int to1=(int)to;
            int temp = from1 + (int)(Math.random()*(to1-from1));
            res[i]=(char)temp;
        }
        return res;
    }
    public static char[] encrypt(char[] arr){
        for(int i=0;i<arr.length;i+=2){
            char temp=arr[i];
            arr[i]= arr[i+1];
            arr[i+1]=temp;
        }
        return arr;
    }
    public static char[] decrypt(char[] arr){
        for(int i=0;i<arr.length;i+=2){
            char temp=arr[i];
            arr[i]= arr[i+1];
            arr[i+1]=temp;
        }
        return arr;
    }
    public static void printArray(char[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}