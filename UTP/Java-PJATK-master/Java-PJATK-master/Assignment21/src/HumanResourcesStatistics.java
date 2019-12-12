import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import employee.Employee;
import employee.Manager;
import employee.Worker;
import payroll.PayrollEntry;
import static java.util.stream.Collectors.toList;

public final class HumanResourcesStatistics {

    public static List<PayrollEntry> payroll(List<Employee> employees) {
        List<PayrollEntry> payroll1 = employees
                .stream()
                .filter(e -> e instanceof Worker)
                .map(e -> new PayrollEntry(e, e.getSalary(), ((Worker) e).getBonus()))
                .collect(toList());

        List<PayrollEntry> payroll2 = employees.stream()
                .filter(e -> !(e instanceof Worker))
                .map(e -> new PayrollEntry(e, e.getSalary(), new BigDecimal(0)))
                .collect(toList());

        List merged = new ArrayList(payroll1);
        merged.addAll(payroll2);

        return merged;

    }

    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {

        return payroll(manager.subordinates);

    }

    public static BigDecimal bonusTotal(List<Employee> employees) {

        BigDecimal total = employees
                .stream()
                .filter(e -> e instanceof Worker)
                .map(e -> ((Worker) e).getBonus())
                .reduce(BigDecimal::add)
                .get();
        return total;
    }

    public static Employee longestSen(List<Employee> employees) {
        return employees
                .stream()
                .filter((e -> e instanceof Worker))
                .map(e -> (Worker) e)
                .min(Comparator.comparing(Worker::getDate))
                .get();
    }

    public static double highest(List<Employee> employees) {
        Employee h = employees
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get();

        return h.getSalary().doubleValue();

    }

    public static double highestWithBonus(List<Employee> employees) {
        PayrollEntry h = payroll(employees)
                .stream()
                .max(Comparator.comparing(PayrollEntry::get_salaryPlusBonus))
                .get();
        return h.get_salaryPlusBonus().doubleValue();
    }

    public static List<Employee> AEmployee(Manager manager) {
        List<Employee> emp = manager.subordinates
                .stream()
                .filter(e -> e.get_surname().charAt(0) == 'A')
                .collect(toList());
        return emp;
    }

    public static List<Employee> earnMore(List<Employee> employees) {
        List<Employee> emp = payroll(employees)
                .stream()
                .filter(p -> p.get_salaryPlusBonus().compareTo(new BigDecimal(1000)) > 0)
                .map(p -> p.get_employee())
                .collect(toList());
        return emp;
    }

}