package eu.glowacki.utp.assignment04;

import eu.glowacki.utp.assignment04.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment04.comparators.FirstNameComparator;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
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
		List<Date> dates = data.stream().map(Person::get_birthdate).collect(Collectors.toList());
		dates.forEach(date -> {
			List<Person> match = data
					.stream()
					.filter(p-> (p.get_birthdate().compareTo(date)==0))
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
}