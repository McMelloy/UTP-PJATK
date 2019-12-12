package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Trainee extends Employee {

	// attributes:
	// * practice start date
	// * practice length (in days)
	private LocalDate startDate;
	private int practiceLength;
	
	public Trainee(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
				   LocalDate startDate) {
		super(firstName, surname, birthDate, salary, manager);
		this.startDate = startDate;
		LocalDate present = LocalDate.now();
		practiceLength = (int)startDate.until(present, ChronoUnit.DAYS);
	}

	@Override
	public BigDecimal bonus() {
		return BigDecimal.ZERO;
	}

	@Override
	public int seniority() {
		return practiceLength;
	}
}