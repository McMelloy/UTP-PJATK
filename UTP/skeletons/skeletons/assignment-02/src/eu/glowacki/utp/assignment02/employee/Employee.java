package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)
	private BigDecimal salary;
	Manager manager;
	
	protected Employee(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager) {
		super(firstName, surname, birthDate);
		this.salary = salary;
		this.manager = manager;
		if(manager!=null) this.manager.addSub(this);
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Manager getManager() {
		return manager;
	}

	public abstract BigDecimal bonus();

	public abstract int seniority();
}