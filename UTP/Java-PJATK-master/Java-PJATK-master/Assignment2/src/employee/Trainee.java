package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

    // (assignment 03)
    // * practice length is shorter than given number of days
    // * practice length is longer than given number of days

    public LocalDate startDate;
    private int lenghtOfPractice;

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

    public int getLenghtOfPractice() {
        return lenghtOfPractice;
    }


    public boolean isShorter(int numOfDay) {
        return this.lenghtOfPractice < numOfDay;
    }

    public boolean isLonger(int numOfDay) {
        return this.lenghtOfPractice > numOfDay;
    }

}