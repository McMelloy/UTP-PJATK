package generators;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenPesel {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");

    public static String genPesel(Date birth){
        Random r = new Random();
        String pesel="";
        pesel+=dateFormat.format(birth);
        pesel+=String.valueOf(r.nextInt(900)+100);
        int rNum = r.nextInt(10);
        while(rNum%2!=1)
            rNum = r.nextInt(10);
        pesel+=String.valueOf(rNum);
        int controlNum = (int) pesel.charAt(9) * 3;
        controlNum += (int) pesel.charAt(8);
        controlNum += (int) pesel.charAt(7)*9;
        controlNum += (int) pesel.charAt(6)*7;
        controlNum += (int) pesel.charAt(5)*3;
        controlNum = (int) pesel.charAt(4);
        controlNum += (int) pesel.charAt(3)*9;
        controlNum += (int) pesel.charAt(2)*7;
        controlNum += (int) pesel.charAt(1)*3;
        controlNum = (int) pesel.charAt(0);
        controlNum%=10;


        pesel+=String.valueOf(controlNum);
        return pesel;
    }
}
