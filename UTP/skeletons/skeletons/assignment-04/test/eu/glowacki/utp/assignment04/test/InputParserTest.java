package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class InputParserTest {
    private List<Person> list;

    @Before
    public void before() {
        list = InputParser.parse(new File("in.txt"));
    }

    @Test
    public void notNull() {
        for (Person p : list) {
            Assert.assertNotNull(p);
        }
    }

    @Test
    public void output() {
        List<Person> data = InputParser.parse(new File("in.txt"));
        data.stream().forEach(per ->{
            System.out.println(per.get_firstName()+" "+per.get_surname()+" "+per.get_birthdate());
        });
    }

    @Test
    public void equals() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = format.parse("1935-12-01");
        String person = "Woody Allen " + date;
        Assert.assertEquals(list.get(6).toString(), person);
    }

}