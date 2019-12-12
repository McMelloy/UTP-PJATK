import java.util.regex.*;
import java.io.*;
public class Reg2{
    public static void main(String[] args){

        InputStream is;
        StringBuilder sb = new StringBuilder();
        try{
            is = System.in;
            int a;
            while(true){
                a =is.read();
                sb.append((char)a);
                if(a == '\n'){
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //System.out.println(sb);
        Pattern p = Pattern.compile("[\\w|\\.]+@([\\w]+\\.?)+[\\w]+\\n");
        Matcher m = p.matcher(sb.toString());
        System.out.println(m.matches());
    }
}