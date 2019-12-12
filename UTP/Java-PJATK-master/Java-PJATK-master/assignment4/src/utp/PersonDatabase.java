package utp;

import Comporators.*;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
    private List<Person> tmp;
    Map<Date,List<Person>> map = null;
    public PersonDatabase() {
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
    }


    public List<Person> sortedByFirstName() {
        Collections.sort(tmp, new FirstNameComparator());
        return tmp;
    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        Collections.sort(tmp, Comparator.naturalOrder());
        return tmp;
    }

    public List<Person> sortedByBirthdate() {
        Collections.sort(tmp, new BirthdateComparator());
        return tmp;
    }

    public List<Person> bornOnDay(Date date) {
        createMap(tmp);
        return map.get(date);
    }

    public Map<Date, List<Person>> createMap(List<Person> people) {
       return map = people.stream().collect(Collectors.groupingBy(Person::get_birthdate,Collectors.toList()));
    }

    @Override
    public String toString(){
        return Arrays.toString(tmp.toArray());
    }
}