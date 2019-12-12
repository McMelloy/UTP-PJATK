import java.util.regex.*;
public class Reg1{
    public static void main(String[] args){
        Pattern p = Pattern.compile("[12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])");
        Matcher m = p.matcher("2010-01-01");
        System.out.println(m.matches());
    }
}

