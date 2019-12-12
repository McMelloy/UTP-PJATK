package employee;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private final String _firstName;
    private final String _surname;
    private final LocalDate _dateOfBirth;


    protected Person(String firstName, String surname, LocalDate dateOfBirth) {

        _firstName = firstName;
        _surname = surname;
        _dateOfBirth = dateOfBirth;

    }

    public String getFirstName() {

        return _firstName;
    }

    public String get_surname() {
        return _surname;
    }

    public LocalDate getDateOfBirth() {
        return _dateOfBirth;
    }

    public int age() {
        LocalDate currentDate = LocalDate.now();

        return Period.between(_dateOfBirth, currentDate).getYears();
    }

    public int compareAge(Person p) {
        if(this._dateOfBirth.compareTo(p.getDateOfBirth()) > 0) {
            return -1;
        } else if(this._dateOfBirth.compareTo(p.getDateOfBirth()) == 0){
            return 0;
        } else return 1;
    }

    public boolean isOlder(Person p) {
        return compareAge(p) == 1;
    }

    public boolean isOlder(int age) {
        return this.age() > age;
    }

    public boolean isYounger(Person p) {
        return compareAge(p) == -1;
    }


}