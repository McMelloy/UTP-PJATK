package utp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class PersonDatabaseTest {

    PersonDatabase p;

    List<Person> test1;
    List<Person> test2;
    List<Person> test3;
    List<Person> test4;

    @BeforeEach
    void before(){

        p = new PersonDatabase();

        test1 = new ArrayList<>();
        test2 = new ArrayList<>();
        test3 = new ArrayList<>();
        test4 = new ArrayList<>();
        Person p0 = null;
        Person p1 = null;
        Person p2 = null;
        Person p3 = null;
        Person p4 = null;
        Person p5 = null;
        try {
            p0 = new Person("Raffaello", "Iliott", new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-06"));
            p1 = new Person("Violet","Dackinson",new SimpleDateFormat("yyyy-MM-dd").parse("1998-10-12"));
            p2 = new Person("John","Lashuk",new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12"));
            p3 = new Person("Alice","Lashuk",new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12"));
            p4 = new Person("John","Lashuk",new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-11"));
            p5 = new Person("John","Lashuk",new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-11"));
        }catch (ParseException e) {
            System.out.println(e);
        }
        test1.add(p3);
        test1.add(p4);
        test1.add(p5);
        test1.add(p2);
        test1.add(p0);
        test1.add(p1);

        test2.add(p1);
        test2.add(p0);
        test2.add(p4);
        test2.add(p5);
        test2.add(p3);
        test2.add(p2);

        test3.add(p1);
        test3.add(p0);
        test3.add(p3);
        test3.add(p4);
        test3.add(p5);
        test3.add(p2);

        test4.add(p2);
        test4.add(p3);

    }


    @Test
    void sortedByFirstName() {
        //System.out.println("Sort by first name");

        List<Person> sorted = p.sortedByFirstName();
        System.out.println(sorted.toString());
        System.out.println(sorted.size());
        for(int i = 0; i < sorted.size(); i++) {
            assertEquals(test1.get(i).get_firstName(), sorted.get(i).get_firstName());
        }
    }

    @Test
    void sortedByBirthdate() {
//        System.out.println("sortedByBirthdate");
        List<Person> sorted = p.sortedByBirthdate();
        System.out.println(sorted.size());
        //System.out.println(test2.toString());
        for(int i = 0; i < sorted.size(); i++) {
            assertEquals(test2.get(i).get_birthdate() ,sorted.get(i).get_birthdate());
        }
    }

    @Test
    void sortedBySurnameFirstNameAndBirthdate() {
//        System.out.println("sortedBySurnameFirstNameAndBirthdate");
        List<Person> sorted = p.sortedBySurnameFirstNameAndBirthdate();
        System.out.println(sorted.size());
//        System.out.println(p.toString());
        System.out.println(sorted.toString());
        for(int i = 0; i < sorted.size(); i++) {
            assertEquals(test3.get(i).get_firstName() ,sorted.get(i).get_firstName());
            assertEquals(test3.get(i).get_surname() , sorted.get(i).get_surname());
            assertEquals(test3.get(i).get_birthdate() , sorted.get(i).get_birthdate());
        }
    }

    @Test
    void bornOnDay(){
        List<Person> date = new ArrayList<>();
        //System.out.println(.size());
//        System.out.println("born on day");
//        try {
//            System.out.println(p.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12")).toString());
//        } catch(ParseException e) {
//            System.out.println(e);
//        }
        try {
            date = p.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12"));
        } catch(ParseException e) {
            System.out.println(e);
        }

        for(int i = 0; i < date.size(); i++) {

            assertEquals(test4.get(i).get_firstName(),date.get(i).get_firstName() );
            assertEquals(test4.get(i).get_surname(), date.get(i).get_surname());
            assertEquals(test4.get(i).get_birthdate(),date.get(i).get_birthdate());
        }

    }

}