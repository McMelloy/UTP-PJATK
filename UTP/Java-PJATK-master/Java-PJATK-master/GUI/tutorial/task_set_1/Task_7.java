import java.util.Scanner;

import java.io.*;
public class Task_7 {
    public static void main(String[] args) {
        File file = null;
        FileWriter f = null;
        Scanner scan = null;
        try {
            file = new File("/Users/alice/Coding/Java/GUI/tutorial/task_set_1/A.txt");
            f = new FileWriter("out.txt", true);
            scan = new Scanner(file);
        } catch(IOException e) {
            System.out.println(e);
        }
        
        boolean x = true;
        while(x){
            if (scan.hasNextInt() && scan.hasNextInt()){
                int k = scan.nextInt();
                int l = scan.nextInt();
                try {
                    f.write(Integer.toString(k+l));
                    f.write('\n');
                } catch(IOException e) {
                    System.out.println(e);
                }
                System.out.println(k+l);

            }else if (scan.hasNextDouble() || scan.hasNextDouble()){
                try {
                    f.write(Double.toString(scan.nextDouble()+scan.nextDouble()));
                } catch(IOException e) {
                    System.out.println(e);
                }
                //System.out.println(c+d);
            }else {
                x = false;
            }
        }
        try {
            f.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
