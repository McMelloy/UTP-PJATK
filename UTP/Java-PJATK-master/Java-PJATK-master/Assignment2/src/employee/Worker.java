package employee;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Worker extends Employee {

    private LocalDate _employementDate;
    private BigDecimal bonus;
    private boolean hasBonus = false;

    public Worker(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager, BigDecimal bonus,
                  LocalDate employementDate) {

        super(firstName, surname,dateOfBirth, salary, manager);

        _employementDate = employementDate;
        this.bonus = bonus;

        if (bonus != null) {
            hasBonus = true;
        }

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

    public boolean isHasBonus() {
        return hasBonus;
    }

    public LocalDate get_employementDate() {
        return _employementDate;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public LocalDate getDate() {
        return _employementDate;
    }

    public boolean isLongerYear(int years) {
        return (LocalDate.now().getYear() - this._employementDate.getYear()) > years;
    }

    public boolean isLongerMonth(int mon) {
        return (LocalDate.now().getYear() - this._employementDate.getYear())*12
                + (LocalDate.now().getMonthValue() - this._employementDate.getMonthValue()) > mon;
    }

    public boolean hasGreaterBonus(BigDecimal bon) {
        if(!this.hasBonus) return false;

        return this.bonus.compareTo(bon) > 0 ;
    }

}