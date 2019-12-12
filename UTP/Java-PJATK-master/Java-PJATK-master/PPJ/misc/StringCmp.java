import java.util.*;
public class StringCmp {
    public static void main (String[] args) {
        String[] arr = {"Kate", "Bea", "Mary", "Bea", "Zoe"};
        System.out.println(Arrays.toString(arr));
        sortSel(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(isLess("bsdjhgg", "cfdsdgg"));
    }

    public static boolean isLess (String a, String b) {
        if(a.length() < b.length()){
            return true;
        } else if(a.length() == b.length()){
            return a.compareTo(b)<0;
            /*int cmp = a.compareTo(b);
            
            if(cmp < 0) {
                return true;
            } return false;
            */
        } return false;
    }
    public static String[] sortSel(String[] arr){
        String tmp = "";
        for(int i=0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(!isLess(arr[i], arr[j])) {
                    tmp = arr[i];  
                    arr[i] = arr[j];  
                    arr[j] = tmp;  
                }  
            }  
        }  
        return arr;
    }
}