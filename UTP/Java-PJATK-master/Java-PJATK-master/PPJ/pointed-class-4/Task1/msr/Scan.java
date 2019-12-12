package msr;
import java.io.*;

public class Scan{
    private InputStream c;
    public Scan(InputStream c){
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
                if (k != ' '){
                    while (k != ' '){
                        b.append((char)k);
                        k = read();
                    }
            }
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
            int a = read();
            
            while(!(Character.isDigit((char)(a)))){
                a = read();
            }
        return Character.getNumericValue(a);
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