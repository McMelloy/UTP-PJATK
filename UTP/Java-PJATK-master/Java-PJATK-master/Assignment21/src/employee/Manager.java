package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Manager extends Worker {

    // attributes
    // * subordinates (a list of immediate subordinates)
    // * all subordinates (a list of subordinates in all hierarchy)
    public ArrayList<Employee> subordinates = new ArrayList<>();

    public Manager(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager, BigDecimal bonus,
                   LocalDate employementDate) {

        super(firstName, surname, dateOfBirth, salary, manager, bonus, employementDate);

    }

    public Manager(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, BigDecimal bonus,
                   LocalDate employementDate) {

        this(firstName, surname, dateOfBirth, salary, null, bonus, employementDate);
    }

    public void addSub(Employee e) {

        subordinates.add(e);
    }





}