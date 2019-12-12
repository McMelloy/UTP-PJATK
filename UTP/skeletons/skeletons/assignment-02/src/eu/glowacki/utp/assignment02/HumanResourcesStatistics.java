package eu.glowacki.utp.assignment02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public final class HumanResourcesStatistics {

	public static List<PayrollEntry> payroll(List<Employee> employees) {
		//List<PayrollEntry> res = new ArrayList<>();
		//employees.forEach(emp -> res.add(new PayrollEntry(emp, emp.getSalary(), emp.bonus())));
		//return res;
		return employees
				.stream()
				.map(emp -> new PayrollEntry(emp, emp.getSalary(), emp.bonus()) )
				.collect(Collectors.toList());
	}

	public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
		//List<PayrollEntry> res = new ArrayList<>();
		//manager.getDirectSub().forEach(emp -> res.add(new PayrollEntry(emp, emp.getSalary(), emp.bonus())));
		//return res;
		return manager.getSub()
				.stream()
				.map(emp -> new PayrollEntry(emp, emp.getSalary(), emp.bonus()) )
				.collect(Collectors.toList());

	}

	public static BigDecimal bonusTotal(List<Employee> employees) {
		return employees
				.stream()
				.map(Employee::bonus)
				.reduce(BigDecimal.valueOf(0), BigDecimal::add);
	}

	public static Employee longestSeniority(List<Employee> employees){
		int longest = employees
				.stream()
				.map(Employee::seniority)
				.reduce(0, Integer::max);
		return employees
				.stream()
				.filter(emp -> emp.seniority()==longest)
				.findFirst()
				.get();
	}

	public static BigDecimal highestSalMinus(List<Employee> employees){
		return employees
				.stream()
				.map(Employee::getSalary)
				.reduce(BigDecimal.ZERO, BigDecimal::max);
	}

	public static BigDecimal highestSalPlus(List<Employee> employees){
		List<BigDecimal> salPlusBonus = employees
				.stream()
				.map(emp -> emp.getSalary().add(emp.bonus()))
				.collect(Collectors.toList());
		return salPlusBonus.stream().reduce(BigDecimal.ZERO,BigDecimal::max);
	}

	public static List<Employee> weirdQueryInvolvingA(Manager manager){
		return manager.getAllSub()
				.stream()
				.filter(emp -> emp.getSurname().startsWith("A"))
				.collect(Collectors.toList());
	}

	public static List<Employee> employeesWhoEarnAtLeastBareMinimum(List<Employee> employees){
		return employees
				.stream()
				.filter(emp -> emp.getSalary().compareTo(BigDecimal.valueOf(1000))>0)
				.collect(Collectors.toList());
	}
}