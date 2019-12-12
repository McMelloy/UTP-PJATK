import java.io.*;
import java.lang.StringBuilder;

public class Keyword{
    public static void main (String[] args){
        findKey();
    }

    public static void findKey(){
        String [] arr = {"abstract","assert","boolean","break","byte","case","catch","char","class","const","continue","default","do","double","else","enum","extends","final","finally","float","for","goto","if","implements","import","instanceof","int","interface","long","native","new","package","private","protected","public","return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient","try","void","volatile","while","true","false","null"};

        try{
            FileReader fis = new FileReader("/Users/alice/Coding/Java/RPN.txt");
            int wrt;
            StringBuilder a = new StringBuilder();
            while((wrt = fis.read()) != -1){
                a.append((char)wrt);
            } 
            int count =0;
            
            for (String k : arr) {
                int last =0;
                count = 0;
                while((last= a.indexOf(k, last+1))!= -1){
                    count++;
                }
                System.out.println(k+" count "+count);
            }
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }
        fis.close();
    }
}