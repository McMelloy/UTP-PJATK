import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import employee.*;
import payroll.PayrollEntry;

import static java.util.stream.Collectors.toList;

public final class HumanResourcesStatistics {

    public static List<PayrollEntry> payroll(List<Employee> employees) {
        return employees
                .stream()
                .map(PayrollEntry::new)
                .collect(toList());
    }

    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {

        return payroll(manager.getSubordinates());

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
        List<Employee> emp = manager.getSubordinates()
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

    // * search for Employees older than given employee and earning less than him
    public static List<Employee> olderThenAndEarnMore(List<Employee> allEmployees, Employee employee) {
        return allEmployees
                .stream()
                .filter(e -> (e.isOlder(employee)) && e.isGreater(employee.getSalary())).collect(toList());
    } ///????

    //
    // * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%

    public static void practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
        allEmployees
                .stream()
                .filter(e -> e instanceof Trainee && ((Trainee) e).isLonger(daysCount))
                .forEach(e -> e.setSalary(e.getSalary().multiply(new BigDecimal(1.05))));

    }

    //
    // * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller

    public static void seniorityLongerThanNum(List<Employee> allEmployees, int monthCount) {
        allEmployees
                .stream()
                .filter(e -> e instanceof Worker
                        && ((Worker) e).isLongerMonth(monthCount)
                        && !((Worker) e).hasGreaterBonus(new BigDecimal(300)))
                .forEach(e -> ((Worker) e).setBonus(new BigDecimal(300)));

    }

    //
    // * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%

    public static void seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
        allEmployees
                .stream()
                .filter(e -> e instanceof Worker && ((Worker) e).isLongerYear(1)&& !((Worker) e).isLongerYear(3))
                .forEach(e -> e.setSalary(e.getSalary().multiply(new BigDecimal(1.10))));
    }

    //
    // * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee

    public static void seniorityLongerThan(List<Employee> allEmployees, Employee employee) {
        allEmployees
                .stream()
                .filter(e -> e instanceof Worker
                        && ((Worker) e).isLongerMonth((LocalDate.now().getYear() - ((Worker)employee).get_employementDate().getYear())*12 + ((Worker)employee).get_employementDate().getMonthValue())
                && e.isLess(employee.getSalary()))
                .forEach(e -> e.setSalary(employee.getSalary()));
    }

    //
    // * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years

    public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
        return  allEmployees
                .stream()
                .filter(e -> e instanceof Worker
                && ((Worker) e).isLongerYear(2) && !((Worker)e).isLongerYear(4))
                //&& e.isOlder(age))
                .map(e -> (Worker)e)
                .collect(toList());
    }
}