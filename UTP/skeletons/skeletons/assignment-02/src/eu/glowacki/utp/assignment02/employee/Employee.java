package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)
	public BigDecimal salary;
	public Person manager;
	
	protected Employee(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Person manager) {
		super(firstName, surname, birthDate);
		this.salary = salary;
		this.manager = manager;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Person getManager() {
		return manager;
	}

	public abstract BigDecimal bonus();

	public abstract int seniority();
}