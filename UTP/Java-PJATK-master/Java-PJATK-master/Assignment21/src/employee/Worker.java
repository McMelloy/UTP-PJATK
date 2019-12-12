package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class Worker extends Employee {

    private LocalDate _employementDate;
    private BigDecimal bonus;

    public Worker(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager, BigDecimal bonus,
                  LocalDate employementDate) {

        super(firstName, surname,dateOfBirth, salary, manager);

        _employementDate = employementDate;

        this.bonus = bonus;
        if(manager != null) {
            manager.addSub(this);
        }

    }

    public Worker(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, BigDecimal bonus,
                  LocalDate employementDate) {
        this(firstName, surname, dateOfBirth, salary, null, bonus, employementDate);
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public LocalDate getDate() {
        return _employementDate;
    }

}