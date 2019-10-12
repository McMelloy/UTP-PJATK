package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class Manager extends Worker {

	// attributes
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
	List<Employee> directSub;
	List<Employee> allSub;
	
	public Manager(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Person manager,
				   LocalDate employDate, BigDecimal bonus, List<Employee> dir, List<Employee> all) {
		super(firstName, surname, birthDate, salary, manager, employDate, bonus);
		directSub = dir;
		allSub = all;
	}

	public List<Employee> getDirectSub() {
		return directSub;
	}

	public List<Employee> getAllSub() {
		return allSub;
	}
}