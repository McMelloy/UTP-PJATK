import rpn.*;
import java.io.*;
import java.util.Scanner;
public class RPNMain {

    public static void main(String[] args){
        RPNStack b = new RPNStack();
        try{
            
            Scanner scan = new Scanner(new File("/Users/alice/Coding/Java/RPN.txt"));
            scan.useDelimiter(" ");
            //String line = "";
            while(scan.hasNextLine()){
                while(scan.hasNext()){
                    String a = scan.next();
                    System.out.print(a+" ");
                    if(a.equals("+")){
                        double val1 = b.pop();
                        double val2 = b.pop();
                        b.push(val1 + val2);
                    }else if(a.equals("*")){
                        double val1 = b.pop();
                        double val2 = b.pop();
                        b.push(val1 * val2);
                    }else if(a.equals("-")){
                        double val1 = b.pop();
                        double val2 = b.pop();
                        b.push(val2 - val1);
                    }else if(a.equals("/")){
                        double val1 = b.pop();
                        double val2 = b.pop();
                        b.push(val2 / val1);
                    }else {
                        b.push(Integer.parseInt(a));
                    }  
                }
                
            }
        }catch (Exception ex){
            //System.out.println(ex);
        }
        
        System.out.println(" result ="+ b.pop());
            if(!b.empty()){
                b.setTop();
            }
    }
}