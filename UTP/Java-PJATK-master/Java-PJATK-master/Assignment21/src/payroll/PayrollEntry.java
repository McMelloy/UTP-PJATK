package payroll;
import java.math.BigDecimal;

import employee.Employee;
public final class PayrollEntry {

    private final Employee _employee;
    private final BigDecimal _salaryPlusBonus;

    public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus) {
        _employee = employee;
        _salaryPlusBonus = salary.add(bonus); // validate whether salary and bonus are not null

    }

    public BigDecimal get_salaryPlusBonus() {
        return _salaryPlusBonus;
    }

    public Employee get_employee() {
        return _employee;
    }
}