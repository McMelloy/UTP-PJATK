import java.io.*;
import java.nio.*;

public class Task3 {

    public static void main(String[] args) {

        try {
            int w = 176766576;
            FileOutputStream fos = new FileOutputStream("task3.txt");
            fos.write(w);
            fos.write(w >> 8);
            fos.write(w >> 16);
            fos.write(w >> 24);
            fos.close();

            FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/pointed-class-4/task3.txt");
            int v1 = fis.read(),
                v2 = fis.read(),
                v3 = fis.read(),
                v4 = fis.read();
                
            v4 <<= 24;
            v4 += v3 << 16;
            v4 += v2 << 8;
            v4 += v1;

            System.out.println(v4);

        } catch (IOException e) {

        }

    }

}