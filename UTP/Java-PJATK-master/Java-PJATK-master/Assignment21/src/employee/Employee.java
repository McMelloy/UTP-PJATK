package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

    private BigDecimal salary;
    public Manager manager = null;

    //
    // attributes:
    // * salary (use BigDecimal type for representing currency values)
    // * manager (empty if at top of hierarchy)

    protected Employee(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager) {

        super(firstName, surname, dateOfBirth);
        this.salary = salary;
        this.manager = manager;
    }

    protected Employee(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary) {

        super(firstName, surname, dateOfBirth);
        this.salary = salary;
    }

    public BigDecimal getSalary(){
        return salary;
    }


}