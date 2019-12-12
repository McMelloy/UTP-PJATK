package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Trainee extends Employee {

	// (assignment 02)
	// attributes:
	// * practice start date
	// * practice length (in days)
	
	// (assignment 03)
	// * practice length is shorter than given number of days
	// * practice length is longer than given number of days
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

    public boolean practiceShorter(int days){
        return practiceLength<days;
    }
    public boolean practiceLonger(int days){
        return practiceLength>days;
    }
}