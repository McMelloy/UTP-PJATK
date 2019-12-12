import java.io.*;
public class Compression {
    public static void main(String[] args){
        try{
            FileInputStream fil = new FileInputStream("/Users/alice/Coding/Java/sign_1.ppm");
            int wrt = fil.read();
           while(wrt!= -1){
               System.out.print(wrt+" ");
               wrt = fil.read();
           }
        } catch (FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }

        }
    }