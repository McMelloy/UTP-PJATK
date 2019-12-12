import java.io.*;
import java.util.ArrayList;


public class ReadBinaryFile{
    public static void main (String[] args){
        try{
            FileInputStream a = new FileInputStream("/Users/alice/Coding/Java/ReadWik.class");
            ArrayList l = new ArrayList<>();
            int in;
            while ((in =a.read()) != -1){
                char c = (char)in;
                if( in > '!' && in <= '~'){
                    System.out.print((char)(in));
                }
                //System.out.print((char)(in));
                
            }
            System.out.println();
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }catch (IOException ex){
            System.out.println(ex);
        }
        
    }
    
}