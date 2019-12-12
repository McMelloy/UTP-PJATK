package eu.glowacki.utp.assignment04;

import java.util.Date;

public class Person implements Comparable<Person> {
	
	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	
	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}

	public String get_firstName() {
		return _firstName;
	}

	public String get_surname() {
		return _surname;
	}

	public Date get_birthdate() {
		return _birthdate;
	}

	@Override
	public int compareTo(Person otherPerson) {
		int comp = this._surname.compareTo(otherPerson._surname);
		if(comp!=0)
			return comp;
		comp = this._firstName.compareTo(otherPerson._firstName);
		if(comp!=0)
			return comp;
		comp = this._birthdate.compareTo(otherPerson._birthdate);
		if(comp!=0)
			return comp;
		return 0;
	}

	@Override
	public String toString() {
		return  _firstName + " "  + _surname + " " + _birthdate ;
	}
}