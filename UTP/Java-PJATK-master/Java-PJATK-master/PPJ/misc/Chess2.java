import java.util.*;
public class Chess2 {
    public static void main (String[] args) { 
        for (String s : new String[]{"a1","d5","g6","c8"})
            System.out.println(s + " -> " + knightMoves(s));
    }
    public static String knightMoves(String pos){
        String[] out = eval(pos.charAt(0), pos.charAt(1));
        return Arrays.toString(out);
    }
    public static String[] eval(char a, char b){
        String [] out = new String [8] ;
        int count = 0;
        for (int l = 0; l < 2; l++){
            for (int k = -2; k < 3; k++){ // only -2 +2 runs twice 
                for (int p = -1; p <2; p++){ // only +1 -1 runs twice 
                    if (l==1){
                        char temp = a;
                        a = b;
                        b = temp;
                    }
                    if (p != 0 && k != 0 && k!=-1 && k!=1){ 
                        char f = (char)(a +k);
                        char g = (char)(b +p);
                        //System.out.println("char a: "+f+" char b: "+g);
                        //return string concat with num added second
                        if (Character.isLetter(a)){
                            if(f >= 'a' && f <= 'h' && g>='1' && g<='8'){
                                out[count] = ""+f+g;
                                count++;
                            }
                            
                        } else {
                            if(g >= 'a' && g <= 'h' && f>='1' && f<='8'){
                                out[count] = ""+g+f;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return out;
    }
}