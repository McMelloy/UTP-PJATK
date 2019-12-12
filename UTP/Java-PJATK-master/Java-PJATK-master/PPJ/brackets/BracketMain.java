import java.io.*;
import pkgbr.*;
public class BracketMain{
    public static void main(String[] args){
        boolean ok = true;
        ParenStack stack = new ParenStack();
        
        try{
            FileInputStream a = new FileInputStream("/Users/alice/Coding/Java/RPN.txt");
            int in;

            while((in = a.read())!= -1){ // 'in' is the read char, 'out' is the poped
                BufferedReader reader = new BufferedReader(new FileReader("/Users/alice/Coding/Java/RPN.txt"));
                int lines = 1;
                while (reader.readLine() != null) 
                {
                    lines++;
                    if((in=='(') || (in=='{') || (in == '[')){
                        stack.push((char)in);
                    } else if ((in==')') || (in=='}') || (in == ']')){
                        char out = stack.pop();
                        char tmp;
                        
                        if(out=='('){
                            tmp=')';
                        }else if(out =='['){
                            tmp=']';
                        }else{
                            tmp='}';
                        }
    
                        if(in==')'){
                            if(out!='('){
                                throw new ErrorEx(lines, (char)in, tmp);
                            }
                        }else if(in=='}'){
                            if(out!='{'){
                                throw new ErrorEx(lines, (char)in, tmp);
                            }
                        }else if(in==']'){
                            if(out!='['){
                                throw new ErrorEx(lines, (char)in, tmp);
                            }
                        }
                    } 
                }
                reader.close(); 
            }
            
        }catch(FileNotFoundException ex){
            System.out.println(ex);
            ok = false;
        }catch(IOException ex){
            System.out.println(ex);
            ok=false;
        }catch(ErrorEx ex){
            ok = false;
        }

        if(ok){
            System.out.println("OK");
        }
    }
}