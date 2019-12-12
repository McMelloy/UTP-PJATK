package classes;

import java.util.Date;
import java.util.Objects;
import extensions.*;

abstract public class Person implements Comparable<Person>{

    private final int _PESEL;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private Nationality _nationality;

    public Person(String firstName, String lastName, Date dateOfBirth, Nationality nationality,int pesel){
        _firstName = firstName;
        _lastName = lastName;
        _dateOfBirth = dateOfBirth;
        _nationality = nationality;
        _PESEL = pesel;
        PersonExt.personHashSet.add(this);
    }

    public int get_PESEL() {
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
    public int compareTo(Person o) {
        if(_PESEL > o.get_PESEL()) {
            return 1;
        } else if(_PESEL < o.get_PESEL()){
            return -1;
        } else if(_firstName.compareTo(o.get_firstName()) > 0) {
            return 1;
        } else if(_firstName.compareTo(o.get_firstName()) < 0) {
            return -1;
        } else if (_lastName.compareTo(o.get_lastName()) > 0) {
            return 1;
        }  else if (_lastName.compareTo(o.get_lastName()) < 0) {
            return -1;
        } else if (_nationality.compareTo(o.get_nationality()) > 0) {
            return 1;
        } else if (_nationality.compareTo(o.get_nationality()) < 0) {
            return -1;
        } else if(_dateOfBirth.compareTo(o.get_dateOfBirth()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return _PESEL == person._PESEL &&
                Objects.equals(_firstName, person._firstName) &&
                Objects.equals(_lastName, person._lastName) &&
                Objects.equals(_dateOfBirth, person._dateOfBirth) &&
                _nationality == person._nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_PESEL, _firstName, _lastName, _dateOfBirth, _nationality);
    }
}
