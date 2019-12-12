public class Task2{
    public static void main(String[] args){
        char [] arr ={
            'a', 'l', 'a', 'm', 'a', 'k', 'o', 't', 'a'
        };
        int count=0;
        for (int k = 0; k < arr.length; k++) {
            if(arr[k] == 'a'){
                count++;
            }
        }
        System.out.println(count);
    }
}