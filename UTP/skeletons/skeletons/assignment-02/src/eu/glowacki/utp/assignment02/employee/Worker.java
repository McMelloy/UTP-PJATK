package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Worker extends Employee {

	// attributes
	// * employment date
	// * bonus

	private BigDecimal bonus;
	private LocalDate employDate;
	
	public Worker(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
				  LocalDate employDate, BigDecimal bonus) {
		super(firstName, surname, birthDate, salary, manager);
		this.employDate = employDate;
		this.bonus = bonus;
	}

	@Override
	public BigDecimal bonus() {
		return bonus;
	}

	@Override
	public int seniority() {
		LocalDate present = LocalDate.now();
		return (int)employDate.until(present, ChronoUnit.DAYS);
	}

}