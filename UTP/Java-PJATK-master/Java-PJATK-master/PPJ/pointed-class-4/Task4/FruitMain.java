import java.io.*;

import frt.Fruit;

public class FruitMain {
    public static void main(String[]args){
        Fruit a = new Fruit("Watermellon ", 153859);
        Fruit b = new Fruit("Apple ", 6);
        try {  
            FileOutputStream fos = new FileOutputStream("/Users/alice/Coding/Java/new1file.txt");
            int w = a.getNumber();
            int w1 = b.getNumber();

            fos.write(a.getName().getBytes());

            fos.write(w);
            fos.write(w >> 8);
            fos.write(w >> 16);
            fos.write(w >> 24);

            fos.write(b.getName().getBytes());

            fos.write(w1);
            fos.write(w1 >> 8);
            fos.write(w1 >> 16);
            fos.write(w1 >> 24);
            fos.close();

           
            

        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

        try{
            FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/new1file.txt");// path
            int wrt = fis.read();
            String c ="";
            while(wrt!= ' ' ){
                c+=(char)wrt;
                wrt = fis.read();
            }
            System.out.println(c);

            int v1 = fis.read(),
                v2 = fis.read(),
                v3 = fis.read(),
                v4 = fis.read();

                v4 <<= 24;
                v4 += v3 << 16;
                v4 += v2 << 8;
                v4 += v1;
                System.out.println(v4);
                
                int rt = fis.read();
                String n ="";
                while(rt!= ' '){
                    n+=(char)rt;
                    rt = fis.read();
                }

                System.out.println(n);

                int v5 = fis.read(),
                v6 = fis.read(),
                v7 = fis.read(),
                v8 = fis.read();

                v8 <<= 24;
                v8 += v7 << 16;
                v8 += v6 << 8;
                v8 += v5;                  
            
                
            
            System.out.println(v8);
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
    }
} 