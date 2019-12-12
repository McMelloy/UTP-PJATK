package msr;
import java.io.*;

public class MyScanner{
    private InputStream c;
    public MyScanner(InputStream c){
        this.c = c;
    }

    public int read(){
        try {
            return c.read();
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }

    public String readWord(){
            int k = read();
            StringBuilder b = new StringBuilder();

            while(k!= -1){
                
                if (k == ' '){
                    while (read() != ' '){
                        b.append((char)k);
                    }
                //return b.toString();
            }
                k = read();
            }
            System.out.println(b);
     
     return b.toString();
        
    }

    public String readLine(){
        int m;
        String g = "";
        while((m = read()) != '\n'){
            g = g+ (char)m;
        }
        //return g;
    return g;
    }

    public int readInteger(){
            int a;
            
            while((a = read()) != -1){
                if(Character.isDigit((char)a)){
                    return a;
                }
                a = read();
            }
        return a;
    }

    public int readPositiveInteger() throws Exception{
        int z;
        if((z = readInteger()) > 0){
            return z;
        }else {
            throw new Exception();
        }
    }
}