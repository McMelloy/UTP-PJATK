import java.util.Arrays;

public class Chess {

    public static String[] knightMoves(String pos) {
        char x = pos.charAt(0);
        char y = pos.charAt(1);
        String [] out = new String [8];
        for(int i = 0; i < out.length; i++){
            out[i] ="";
        }
        int index =0;
        int count=1;
        for (int k = -2; k < 3; k++){
            if(count > 3 && count < 7 ){
                for (int e = -2; e < 3; e++){ //diff for 2 through 5
                    if (e <-1 && e > 1 ){
                        char d = (char)(k);
                        char h = (char)(e);
                        System.out.println(index);
                        // +d -> =h ,, +h -> d
                        out[index] = "" + (char)(x + d) + "" + (char)(y + h);
                        index++;
                        count++; 
                    }
                }
            } else {

                for (int p = -1; p <2; p++){ //diff for 2 through 5
                
                    if (p != 0 && k != 0){
                        char d = (char)(k);
                        char h = (char)(p);
                        System.out.println(index);
                        // +d -> =h ,, +h -> d
                        out[index] = "" + (char)(x + d) + "" + (char)(y + h);
                        index++;
                        count++;
                       // System.out.println(x+""+d+""+y+""+h);
                    }
                }     
            }
        }
            
        
        //swap x and y and run again
    

return out;
    }
    public static void main (String[] args) {
        System.out.println(Arrays.toString(knightMoves("d5")));
        /*
        for (String s : new String[]{"A1","d5","g6","C8"})
            System.out.println(s + " -> " + knightMoves(s));*/
    }
}