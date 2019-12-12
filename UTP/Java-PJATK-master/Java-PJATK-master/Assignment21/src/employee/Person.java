package employee;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private final String _firstName; // backing field
    private final String _surname;
    private final LocalDate _dateOfBirth;


    protected Person(String firstName, String surname, LocalDate dateOfBirth) {

        _firstName = firstName;
        _surname = surname;
        _dateOfBirth = dateOfBirth;

    }

    public String getFirstName() { // getter

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
        if ((_dateOfBirth != null) && (currentDate != null)) {
            return Period.between(_dateOfBirth, currentDate).getYears();
        }

        return 0;
    }
}