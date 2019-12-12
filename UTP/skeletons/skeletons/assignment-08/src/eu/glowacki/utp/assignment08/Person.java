package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Serializable;
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

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		try {
			output.writeUTF(get_firstName());
			output.writeUTF(get_surname());
			output.writeLong(get_birthDate().getTime());
		} catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception.getCause());
		}
	}
	
	public static Person deserialize(DataInputStream input) throws Assignment08Exception {
		String name;
		String surname;
		Date birthdate;
		try {
			if(input.available() > 0) {
				name = input.readUTF();
				surname = input.readUTF();
				birthdate = new Date(input.readLong());
			} else {
				return null;
			}

		} catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception.getCause());
		}
		return new Person(name,surname,birthdate);
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

	public String get_firstName() {
		return _firstName;
	}

	public String get_surname() {
		return _surname;
	}

	public Date get_birthDate() {
		return _birthdate;
	}
}