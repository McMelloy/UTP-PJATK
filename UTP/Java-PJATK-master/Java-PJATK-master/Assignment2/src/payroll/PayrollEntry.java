package payroll;
import java.math.BigDecimal;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import employee.Employee;
import employee.Worker;

public final class PayrollEntry {

    private static BigDecimal salaryPlusBonusImpl(Employee emp) {
        if (emp instanceof Worker) {
            Worker worker = (Worker)emp;
            return worker.getSalary().add(worker.getBonus());
        }
        return emp.getSalary();
    }

    private final Employee _employee;
    private final BigDecimal _salaryPlusBonus;

    public PayrollEntry(Employee employee) {
        _employee = employee;
        _salaryPlusBonus = salaryPlusBonusImpl(employee);
    }

    public BigDecimal get_salaryPlusBonus() {
        return _salaryPlusBonus;
    }

    public Employee get_employee() {
        return _employee;
    }
}