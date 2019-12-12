import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.*;
public class Regular{
    public static void main(String[] args){
        FileInputStream fil = null;
        ArrayList arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try {
            fil = new FileInputStream("/Users/alice/Coding/Java/RPN.txt");
            int c;
            while((c = fil.read()) != -1) {
                sb.append((char)(c));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String a = sb.toString();
        String reg = "(http://|https://|www.)\\w+\\.\\w+";
        String [] spl = a.split(" ");
        int i = 1;
        Pattern pat = Pattern.compile(reg);
        for(String b : spl){
            Matcher m = pat.matcher(b);
            if(m.find()){
                System.out.println(i + ": "+ b);
                i++;
            } 
        }
    }
}