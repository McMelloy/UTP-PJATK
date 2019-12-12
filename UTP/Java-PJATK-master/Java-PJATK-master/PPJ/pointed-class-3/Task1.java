public class Task1{
    public static void main(String[] args){
        String [] words ={
            "Ala", "kota", "ma", "ma", "a", "kot", "Ale"
        };
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k]+" ");
        }
        System.out.println();
        String temp;
        
        for (int i = 1; i < words.length-2; i++){
            if(i!= 2){
            temp = words[i];
            //System.out.println("temp "+temp);
            words[i]= words[i+1];
            //System.out.println("arr[i] "+arr[i]);
            words[i+1]= temp;
            //System.out.println("arr[i+1] "+arr[i+1]);
            }
        }
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k]+" ");
        }
}
}