package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

    // attributes:
    // * practice start date
    // * practice length (in days)
    public LocalDate startDate;
    public int lenghtOfPractice;

    public Trainee(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager, LocalDate startDate,
                   int lenghtOfPractice) {

        super(firstName, surname, dateOfBirth, salary, manager);
        this.startDate = startDate;
        this.lenghtOfPractice = lenghtOfPractice;
        manager.addSub(this);
    }

    public Trainee(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, LocalDate startDate,
                   int lenghtOfPractice) {

        this(firstName, surname, dateOfBirth, salary, null, startDate, lenghtOfPractice);
    }
}