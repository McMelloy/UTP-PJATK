package eu.glowacki.utp.assignment02.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eu.glowacki.utp.assignment02.employee.Trainee;
import eu.glowacki.utp.assignment02.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.utp.assignment02.HumanResourcesStatistics;
import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public class HumanResourcesStatisticsTest {
	
	// Create a HR structure which resembles the below one:
	//
	// Director (an instance of Manager class (Director does not have a manager)
	//   |- Manager01
	//        |- Worker
	//        |- Worker
	//        |- Trainee
	//        |- ...
	//   |- Manager02
	//        |- ...
	//   |- ...
	//   |- Worker
	//   |- Worker
	//   |- Trainee
	
	private List<Employee> _allEmployees;
	Manager director = new Manager("King","Louis", LocalDate.of(1968,3,16),
			BigDecimal.valueOf(10000.),null,LocalDate.of(2018,1,1),BigDecimal.valueOf(0.));
	Manager manager1 = new Manager("John","Wick",LocalDate.of(1973,12,28),
			BigDecimal.valueOf(7500.),director,LocalDate.of(2018,3,1),BigDecimal.valueOf(1000.1));
	Manager manager2 = new Manager("Konstantin","Wick",LocalDate.of(1981,2,13),
			BigDecimal.valueOf(7500.),director,LocalDate.of(2018,3,1),BigDecimal.valueOf(3000.));
	Worker work1 = new Worker("A Nice","Avocado",LocalDate.of(1996,6,4),
			BigDecimal.valueOf(4500.),manager1,LocalDate.of(2018,3,16),BigDecimal.valueOf(500.));
	Worker work2 = new Worker("Smith","Will",LocalDate.of(1991,1,30),
			BigDecimal.valueOf(3350.),manager1,LocalDate.of(2019,1,1),BigDecimal.valueOf(500.));
	Worker work3 = new Worker("Stan","Stanley III",LocalDate.of(1988,5,20),
			BigDecimal.valueOf(4500.),manager2,LocalDate.of(2018,5,15),BigDecimal.valueOf(500.));
	Trainee train = new Trainee("Noobie","Noobie",LocalDate.of(2001,2,14),
			BigDecimal.valueOf(400.),manager1,LocalDate.of(2019,5,5));// all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)

	@Before
	public void setUp(){
		_allEmployees = new ArrayList<>();
		_allEmployees.add(director);
		_allEmployees.add(manager1);_allEmployees.add(manager2);
		_allEmployees.add(work1);_allEmployees.add(work2);_allEmployees.add(work3);
		_allEmployees.add(train);
	}

	@Test
	public void payroll() {
		HumanResourcesStatistics.payroll(_allEmployees)
				.stream()
				.forEach(pay -> System.out.println(pay.get_salaryPlusBonus()));
	}

	@Test
	public void subordinatesPayroll() {
		HumanResourcesStatistics.subordinatesPayroll(manager2)
				.stream()
				.forEach(pay -> System.out.println(pay.get_salaryPlusBonus()));
	}

	@Test
	public void bonusTotal() {
		BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
		Assert.assertEquals("5500.1", total.toString());
	}

	@Test
	public void longestSeniority() {
		System.out.println(HumanResourcesStatistics.longestSeniority(_allEmployees).getFirstName());
	}

	@Test
	public void highestSalMinus() {
		System.out.println(HumanResourcesStatistics.highestSalMinus(_allEmployees));
	}

	@Test
	public void highestSalPlus() {
		System.out.println(HumanResourcesStatistics.highestSalPlus(_allEmployees));
	}

	@Test
	public void weirdQueryInvolvingA() {
		HumanResourcesStatistics.weirdQueryInvolvingA(director)
				.stream()
				.forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()));
	}

	@Test
	public void employeesWhoEarnAtLeastBareMinimum() {
		HumanResourcesStatistics.employeesWhoEarnAtLeastBareMinimum(_allEmployees)
				.stream()
				.forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()));
	}

}