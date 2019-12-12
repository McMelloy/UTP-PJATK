package pkg;
public class RecIter{
    //
    public static int fiboR (int n){
        if(n >= 0 && n < 2) {
            return n;
        }
          else {
            return fiboR(n - 1) + fiboR(n - 2);
        }
    }
    //
    public static int fiboI(int n) {
        if(n >= 0 && n < 2) {
            return n;
        }
          else { 
          
          int a = 1;
          int b = 2;
          int c = 0;
          for(int i = 3; i < n; i++) {
            c = a+b;  
            a = b;    
            b = c;   
          }
          return c;
        }
    }
    //
    public static int factR(int n) {
        if (n == 0) {  
            return 1;
        }    
        else { 
            return(n * factR(n-1));
        }  
    }    
    //
    public static int factI(int n) {
        int i = 1;
        int fact = 1;   
        for(i = 1; i <= n; i++) {    
            fact = fact * i;    
        }  
        return fact;  
    }
    //
    public static int gcdR(int a, int b){
        if (a==b){
        return a;
        } else if (a<b){
                b = b - a;
            }
                else{
                    a = a - b;
                }
                
            return gcdR(a, b);
        }
    
    //
    public static int gcdI(int a, int b) {
        while(a>0){
            if (a==b) {
                return a;
            }
        else if (a<b){
            b = b - a;
        }
            else{
                a = a - b;
            }
            }
            return a;
        }
    
    //
    public static int maxElem(int[] arr, int from, int to){
        int max = 0;
        if (to > (arr.length-1)){
            to -= 1;
        }
        if (from > to || from == (to-1)){
            return max;
        }
        else {
            to -= 1;
            if (max < (Math.max(arr[to],arr[from]))) {
                max = Math.max(arr[to],arr[from]);
                //System.out.println("current max: "+max);
            }
            from++;
            maxElem(arr, from, to);
            //return max;
        }
        return max;
        
        }

        //
        public static int [] reverse(int[] arr, int from, int to){  // {7,9,2,8,3}
        int temp = 0;
       if (to > (arr.length-1)){
            to -= 1;
        }
        if (from > to || from == (to-1)){
            return arr;
        }
        else {
            
            temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to -= 1;
            if ((to-from) != 1){
                reverse(arr, from, to);
            }
            else {
            }
            //return max;
        }
        return arr;
    }

   // public static void reserve(int[] arr, int from, int to){}


    //
    public boolean isPalindrom(String s) {
    int length = s.length();
    if (length < 2){ 
        return true;
    }
    else {

        if (s.charAt(0) != s.charAt(length - 1)) {
            return false;
        }
        else{
            return isPalindrom(s.substring(1, length - 1));
        }    
    }
    }
}