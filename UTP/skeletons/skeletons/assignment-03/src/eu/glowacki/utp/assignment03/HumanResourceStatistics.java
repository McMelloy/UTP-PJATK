package eu.glowacki.utp.assignment03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;

public final class HumanResourceStatistics {

	// The best solution is to impleent the below features as static methods having a list of Employee as the first input argument.
	// In addition the list of arguments may be augmented with parameters required for the given feature.

	// (assignment 03)
	// methods:
	//
	// * search for Employees older than given employee and earning less than him
	public static List<Employee> olderThenAndEarnMore(List<Employee> allEmployees, Employee employee) {
		Predicate<Employee> predicate = emp -> (emp.isOlder(employee) && !emp.isSalaryGreater(employee.getSalary()));
		return allEmployees
				.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	//
	// * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%
	public static List<Trainee> practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
		Predicate<Trainee> predicate = tr -> tr.practiceLonger(daysCount);
		Consumer<Trainee> raise = tr -> tr.raiseSalary(0.05);

		/*List<Trainee> res = new ArrayList<>();
		allEmployees
				.forEach(emp-> {
					if (emp instanceof Trainee)
						res.add((Trainee)emp);
				});*/
		allEmployees
				.stream()
				.filter(emp -> emp instanceof Trainee)
				.map(emp -> (Trainee)emp)
				.filter(predicate)
				.forEach(raise);
		return allEmployees
				.stream()
				.filter(emp -> emp instanceof Trainee)
				.map(emp -> (Trainee)emp)
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	//
	// * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller
	public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, int monthCount) {
		Predicate<Worker> predicate = wr -> (!wr.bonusGreater(BigDecimal.valueOf(300)) && wr.seniorityLongerMonths(monthCount));
		Consumer<Worker> giveBonus = wr -> wr.setBonus(BigDecimal.valueOf(300));
		/*List<Worker> res = new ArrayList<>();
		allEmployees
				.forEach(emp-> {
					if (emp instanceof Worker)
						res.add((Worker) emp);
				});*/
		allEmployees
				.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate)
				.forEach(giveBonus);
		return allEmployees.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate).collect(Collectors.toList());
	}
	
	//
	// * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%
	public static List<Worker> seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
		Predicate<Worker> predicate = wr -> (wr.seniorityLongerYears(1) && !wr.seniorityLongerYears(3));
		Consumer<Worker> raise = wr -> wr.raiseSalary(0.1);
		allEmployees
				.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate)
				.forEach(raise);
		return allEmployees.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate).collect(Collectors.toList());
	}
	
	//
	// * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee
	public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, Employee employee) {
		Predicate<Worker> predicate = wr -> (wr.seniorityLongerYears(employee.seniority()) && wr.compareSalary(employee)==-1);
		Consumer<Worker> raise = wr -> wr.setSalary(employee.getSalary());
		allEmployees
				.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate)
				.forEach(raise);
		return allEmployees.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp)
				.filter(predicate).collect(Collectors.toList());
	}
	
	//
	// * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years
	public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
		Predicate<Worker> predicate = wr -> (wr.seniorityLongerYears(2) && !wr.seniorityLongerYears(4) && wr.age()>age);
		/*List<Worker> res = new ArrayList<>();
		allEmployees
				.forEach(emp-> {
					if (emp instanceof Worker)
						res.add((Worker) emp);
				});*/
		return allEmployees.stream()
				.filter(emp -> emp instanceof Worker)
				.map(emp -> (Worker)emp).filter(predicate).collect(Collectors.toList());
	}
}