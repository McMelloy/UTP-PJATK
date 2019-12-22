import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PESEL {
    private static boolean validate(String pesel) {
        if(pesel.length()!=11)
            return false;
        int[] num = new int[pesel.length()];
        for (int i = 0; i < pesel.length(); i++) {
            num[i] = Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
        int check = num[0] + num[1] * 3 + num[2] * 7 + num[3] * 9 + num[4] + num[5] * 3 + num[6] * 7 + num[7] * 9 + num[8] + num[9] * 3;
        if (check % 10 == 0 ) {
            check = 0;
        } else {
            check = 10 - (check % 10);
        }
        return check == num[10];
    }

    private static Date getDate(String pesel) {
        String Peselyear = pesel.substring(0,2);
        int Peselmonth = Integer.parseInt(pesel.substring(2,4));
        int year = 0;
        int month = 0;
        int day = Integer.parseInt(pesel.substring(4,6));
        if(Peselmonth <= 12) {
            year = Integer.parseInt("19" + Peselyear);
            month = Peselmonth;
        } else if(Peselmonth <= 32) {
            year = Integer.parseInt("20" + Peselyear);
            month = Peselmonth - 20;
        } else if(Peselmonth <= 52) {
            year = Integer.parseInt("21" + Peselyear);
            month = Peselmonth - 40;
        } else if(Peselmonth <= 72) {
            year = Integer.parseInt("22" + Peselyear);
            month = Peselmonth - 60;
        }

        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+(month+1)+"-"+day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    private static Gender getGender(String pesel) {
        int sexValue = Integer.parseInt(pesel.substring(9,10));
        if(sexValue % 2 == 0){
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }
}

enum Gender {
    MALE,
    FEMALE;
}