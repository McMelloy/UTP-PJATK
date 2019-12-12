import java.io.*;
import msr.*;

public class MyScannerMain{
    public static void main(String [] args){
        try{
            FileInputStream file = new FileInputStream("/Users/alice/Coding/Java/RPN.txt");
            Scan g = new Scan(file);
            System.out.println(g.readWord());
            System.out.println(g.readLine());
            System.out.println( g.readInteger());
            //System.out.println(g.readPositiveInteger());
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
}