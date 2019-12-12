package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Worker extends Employee {

	// (assignment 02)
	// attributes:
	// * employment date
	// * bonus
	
	// (assignment 03)
	// attributes:
	// * has bonus
	//
	// methods:
	// * seniority is longer than given number of years (seniority)
	// * seniority is longer than given number of months
	// * has bonus greater than given amount of money
    private BigDecimal bonus;
    private LocalDate employDate;
    boolean hasBonus;

    public Worker(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
                  LocalDate employDate, BigDecimal bonus) {
        super(firstName, surname, birthDate, salary, manager);
        this.employDate = employDate;
        this.bonus = bonus;
        hasBonus = bonus != null;
    }

    @Override
    public BigDecimal bonus() {
        return bonus;
    }

    @Override
    public int seniority() {
        LocalDate present = LocalDate.now();
        return (int)employDate.until(present, ChronoUnit.YEARS);
    }

    public boolean seniorityLongerYears(int years){
        LocalDate present = LocalDate.now();
        return ((int)employDate.until(present, ChronoUnit.YEARS))>years;
    }
    public boolean seniorityLongerMonths(int months){
        LocalDate present = LocalDate.now();
        return ((int)employDate.until(present, ChronoUnit.MONTHS))>months;
    }
    public boolean bonusGreater(BigDecimal bon){
        return this.bonus().compareTo(bon)>0;
    }

    public void setBonus(BigDecimal bon){
        bonus = bon;
    }
}