import java.io.*;
public class ReadWik {
    public static void main(String[] args) {   
        fisToString("/Users/alice/Coding/Java/RPN.txt");
        fisToStringBuilder("/Users/alice/Coding/Java/RPN.txt");
        fisToStringBuffer("/Users/alice/Coding/Java/RPN.txt");
    }

    public static void fisToString(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            int wrt;
            String a ="";
            long startTime = System.currentTimeMillis();
            while((wrt = fis.read()) != -1){
                a = a +(char)wrt;

            }
            System.out.println(a);
            System.out.println("time"+ (System.currentTimeMillis() - startTime)) ;
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
    }

    public static void fisToStringBuilder(String path){
        try{
            FileReader fis = new FileReader(path);
            int wrt;
            StringBuilder a = new StringBuilder();
            long startTime = System.currentTimeMillis();
            while((wrt = fis.read()) != -1){
                a.append((char)wrt);
                //wrt = fis.read();
            }
            
            System.out.println(a);
            System.out.println("time"+ (System.currentTimeMillis() - startTime)) ;
            
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
    }

    public static void fisToStringBuffer(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            int wrt= fis.read();
            StringBuffer a = new StringBuffer("");
            long startTime = System.currentTimeMillis();
            while(wrt  != -1){
                a.append((char)wrt);
                wrt = fis.read();
            }
            System.out.println(a);
            System.out.println("time"+ (System.currentTimeMillis() - startTime)) ;
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
    }
}