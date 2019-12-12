package classesAndEnum;

import java.text.Collator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

abstract public class Person implements Comparable<Person>{
    Collator coll = Collator.getInstance(new Locale("pl"));
    private String _PESEL;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private Nationality _nationality;

    public Person(String firstName, String lastName, Date dateOfBirth, Nationality nationality,String pesel){
        _firstName = firstName;
        _lastName = lastName;
        _dateOfBirth = dateOfBirth;
        _nationality = nationality;
        _PESEL = pesel;
    }

    public String get_PESEL() {
        return _PESEL;
    }

    public String get_firstName() {
        return _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public Date get_dateOfBirth() {
        return _dateOfBirth;
    }

    public Nationality get_nationality() {
        return _nationality;
    }


    @Override
    public int hashCode() {
        return Objects.hash(_PESEL, _firstName, _lastName, _dateOfBirth, _nationality);
    }

    @Override
    public int compareTo(Person o) {
        if(coll.compare(_lastName,o.get_lastName()) != 0)
            return coll.compare(_lastName,o.get_lastName());
        return coll.compare(_firstName,o.get_firstName());
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return _PESEL == person._PESEL &&
                Objects.equals(_firstName, person._firstName) &&
                Objects.equals(_lastName, person._lastName) &&
                Objects.equals(_dateOfBirth, person._dateOfBirth) &&
                _nationality == person._nationality;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return
                "PESEL=" + _PESEL +
                ", firstName='" + _firstName + '\'' +
                ", lastName='" + _lastName + '\'' +
                ", dateOfBirth=" + dateFormat.format(_dateOfBirth)+
                ", nationality=" + _nationality;
    }
}
