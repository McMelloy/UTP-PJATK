package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import eu.glowacki.utp.assignment04.PersonDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PersonDatabaseTest {
    PersonDatabase db;

    @Before
    public void read() {
        db = new PersonDatabase(InputParser.parse(new File("in.txt")));
        Assert.assertEquals(db.getData().size(),9);
    }

    @Test
    public void sortedByFirstName(){
        List<Person> res = db.sortedByFirstName();
        res.stream().forEach(per ->{
            System.out.println(per.get_firstName()+" "+per.get_surname()+" "+per.get_birthdate());
        });
        Assert.assertEquals(res.get(0).get_firstName(),"Christopher");
    }

    @Test
    public void sortedBySurnameFirstNameAndBirthdate(){
        List<Person> res = db.sortedBySurnameFirstNameAndBirthdate();
        res.stream().forEach(per ->{
            System.out.println(per.get_firstName()+" "+per.get_surname()+" "+per.get_birthdate());
        });

    }

    @Test
    public void sortedByBirthdate(){
        List<Person> res = db.sortedByBirthdate();
        res.stream().forEach(per ->{
            System.out.println(per.get_firstName()+" "+per.get_surname()+" "+per.get_birthdate());
        });
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res.get(0).get_birthdate());
        Assert.assertEquals(calendar.get(Calendar.YEAR),1928);
        calendar.setTime(res.get(res.size()-1).get_birthdate());
        Assert.assertEquals(calendar.get(Calendar.YEAR),1970);
    }

    @Test
    public void bornOnDay(){
        List<Person> res = db.bornOnDay(Date.valueOf("1970-07-30"));
        res.stream().forEach(per ->{
            System.out.println(per.get_firstName()+" "+per.get_surname()+" "+per.get_birthdate());
        });
        Assert.assertEquals(res.size(),2);
    }


}