package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

    private BigDecimal salary;
    public Manager manager = null;

    // (assignment 03)
    // methods:
    // * salary is greater than given amount of money
    // * salary is less than given amount of money
    // * compare salary with other employee salary


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

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isGreater(BigDecimal sal) {
        return compareSal(sal) > 0;
    }

    public boolean isLess(BigDecimal sal) {
        return compareSal(sal) < 0;

    }

    public int compareSal(BigDecimal sal) {
        return this.salary.compareTo(sal);
    }

}