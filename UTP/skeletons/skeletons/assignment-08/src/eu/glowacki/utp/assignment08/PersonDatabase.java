package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase{
	List<Person> data;

	private static Comparator<Person> defaultSort = Comparator.naturalOrder();
	private static Comparator<Person> birthdateSort = new BirthdateComparator();
	private static Comparator<Person> firstNameSort = new FirstNameComparator();

	private static Map<Date, List<Person>> byBirthdate;

	public PersonDatabase(List<Person> list){
		data = list;
		generateMap();
	}

	public PersonDatabase(File file){
		data = InputParser.parse(file);
		generateMap();
	}

	private void generateMap(){
		byBirthdate = new TreeMap<>();
		List<Date> dates = data.stream().map(Person::get_birthDate).collect(Collectors.toList());
		dates.forEach(date -> {
			List<Person> match = data
					.stream()
					.filter(p-> (p.get_birthDate().compareTo(date)==0))
					.collect(Collectors.toList());
			if(!byBirthdate.containsKey(date))
				byBirthdate.put(date,match);
		});
	}

	public List<Person> sortedByFirstName() {
		List<Person> res = new ArrayList<>(data);
		res.sort(firstNameSort);
		return res;
	}

	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		List<Person> res = new ArrayList<>(data);
		res.sort(defaultSort);
		return res;
	}

	public List<Person> sortedByBirthdate() {
		List<Person> res = new ArrayList<>(data);
		res.sort(birthdateSort);
		return res;
	}

	public List<Person> bornOnDay(Date date) {
		return byBirthdate.get(date);
	}

	public List<Person> getData() {
		return data;
	}


	// assignment 8 - factory method based on deserialization
	public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception {
		List<Person> desList = new ArrayList<>();

		Person p = Person.deserialize(input);
		while (p != null) {
			desList.add(p);
			p = Person.deserialize(input);
		}
		return new PersonDatabase(desList);
	}


	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		try {
			data.forEach(e -> {
				try {
					e.serialize(output);
				} catch (Assignment08Exception ex) {
					ex.printStackTrace();
				}
			});
		} catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception.getCause());
		}
	}

}