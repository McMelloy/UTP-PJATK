import java.io.*;
public class Display {

    public static void main(String[] args){
       try{
           FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/RPN.txt");// path
           int wrt = fis.read();
           String a ="";
           while(wrt!= -1){
               a+=(char)wrt;
               //System.out.println((char)wrt);
               wrt = fis.read();
           }
           System.out.println(a);
    } catch (FileNotFoundException ex){
        System.out.println(ex);
    }catch(IOException ex){
        System.out.println(ex);
    }
}
}