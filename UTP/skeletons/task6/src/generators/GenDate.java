package generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenDate {
    public Date date = new Date();
    public Calendar calendar = Calendar.getInstance();
    public final Random random = new Random();

    public final int startYear;
    public final int offsetYear = 70;

    GenDate(){
        calendar.setTime(date);
        int currentYear = calendar.get(Calendar.YEAR);
        startYear = currentYear - offsetYear;
    }

    public Date generateDateOfBirth(){
        int year = startYear + random.nextInt(54);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(31);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public Date generateDateOfEmployment(){
        int year = startYear + 20 + random.nextInt(54);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(31);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}