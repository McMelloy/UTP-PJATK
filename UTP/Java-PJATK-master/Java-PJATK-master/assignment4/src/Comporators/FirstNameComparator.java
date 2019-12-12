package Comporators;

import java.util.Comparator;

import utp.*;

public class FirstNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.get_firstName().compareTo(person2.get_firstName());
    }
}