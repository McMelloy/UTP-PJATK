import java.io.IOException;
import java.util.Scanner;

import java.io.*;
import java.io.InputStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.*;


public class Main {
    public static void main(String[] args) throws IOException{
        /*InputStream in = System.in;
        int a = in.read();
        while(a!=10){
            char b = (char)a;
            System.out.println(a+ " = "+ b);
            a=in.read();
        }*/
        /*StringBuilder builder = new StringBuilder();
        InputStream in = System.in;
        int a = in.read();
        while(a!=10){
            if(!(a>='0'&&a<='9')) {
                char b = (char) a;
                builder.append(b);
            }
            a=in.read();
        }
        System.out.println(builder);
        */

        /*
        //task 3
        // I'm looking for file's path
        Path fileOut = Paths.get("outputFile.txt");
        // I'm creating buffered writer
        BufferedWriter out = Files.newBufferedWriter(fileOut, UTF_8);
        // In such way I can write strings, chars etc.
        out.write("Hello there,");
        out.write("General Kenobi");
        // Finally I'm closing a file
        out.close();*/

        ////task 5\
        /*File text = new File("A.txt");
        Path fileOut = Paths.get("B.txt");
        BufferedWriter out = Files.newBufferedWriter(fileOut, UTF_8);
        Scanner scanner = new Scanner(text);
        int count = 0;

        while(scanner.hasNextLine()){
            int line = scanner.nextInt();
            count+=line;
        }
        System.out.println(count);
        String str = String.valueOf(count);
        out.write(str);
        out.close();*/
        String s = "135s9";
        /*boolean num = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!(c>='0'&&c<='9')){
                num = false;
                break;
            }
        }
        if(num)
            System.out.println(s.);*/
        try{
            System.out.println(Integer.parseInt(s));
        }
        catch(Exception e){
            System.out.println(0);
        }
    }
}
