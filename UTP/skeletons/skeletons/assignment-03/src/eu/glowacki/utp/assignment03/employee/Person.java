package eu.glowacki.utp.assignment03.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Person {

	// (assignment 02)
	// attributes:
	// * first name
	// * surname
	// * birth date
	// * age (derived --- computed based on birth date)
	
	// (assignment 03)
	// methods:
	// * is older than other person
	// * is younger than other person
	// * compare age with other person's age
    private final String _firstName; // backing field
    private final String _surname;
    private final LocalDate _birthDate;

    protected Person(String firstName, String surname, LocalDate birthDate) {
        _firstName = firstName;
        _surname = surname;
        _birthDate = birthDate;
    }

    public int age(){
        LocalDate present = LocalDate.now();
        return (int)_birthDate.until(present, ChronoUnit.YEARS);
    }

    public String getFirstName() { // getter
        return _firstName;
    }

    public String getSurname() { // getter
        return _surname;
    }

    public boolean isOlder(Person other){
        return this.age()>other.age();
    }

    public boolean isYounger(Person other){
        return this.age()<other.age();
    }

    public int compareAge(Person other){
        return this.age()-other.age();
    }
}