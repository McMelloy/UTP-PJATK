package eu.glowacki.utp.assigment03.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.utp.assignment03.HumanResourceStatistics;
import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Manager;

public class HumanResourceStatisticsTest {

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
    Manager director = new Manager("King","Louis", LocalDate.of(1988,3,16),
            BigDecimal.valueOf(10000.),null,LocalDate.of(2016,1,1),BigDecimal.valueOf(0.));
    Manager manager1 = new Manager("John","Wick",LocalDate.of(1973,12,28),
            BigDecimal.valueOf(7500.),director,LocalDate.of(2016,3,1),BigDecimal.valueOf(1000.1));
    Manager manager2 = new Manager("Konstantin","Wick",LocalDate.of(1981,2,13),
            BigDecimal.valueOf(7500.),director,LocalDate.of(2017,3,1),BigDecimal.valueOf(3000.));
    Manager manager3 = new Manager("Trainee","God",LocalDate.of(1990,2,4),
            BigDecimal.valueOf(7500.),director,LocalDate.of(2019,1,1),BigDecimal.valueOf(3000.));
    Worker work1 = new Worker("A Nice","Avocado",LocalDate.of(1996,6,4),
            BigDecimal.valueOf(4500.),manager1,LocalDate.of(2016,3,16),BigDecimal.valueOf(500.));
    Worker work2 = new Worker("Smith","Will",LocalDate.of(1991,1,30),
            BigDecimal.valueOf(9350.),manager1,LocalDate.of(2018,1,1),BigDecimal.valueOf(500.));
    Worker work3 = new Worker("Stan","Stanley III",LocalDate.of(1988,5,20),
            BigDecimal.valueOf(4500.),manager2,LocalDate.of(2017,5,15),BigDecimal.valueOf(100.));
    Trainee train1 = new Trainee("Noobie","Noobie",LocalDate.of(2001,2,14),
            BigDecimal.valueOf(400.),manager1,LocalDate.of(2019,5,5));
    Trainee train2 = new Trainee("Promising","Student",LocalDate.of(2000,7,1),
            BigDecimal.valueOf(1000.),manager3,LocalDate.of(2019,2,25));
    Trainee train3 = new Trainee("Rich","Student",LocalDate.of(2002,5,14),
            BigDecimal.valueOf(1400.),manager3,LocalDate.of(2019,9,29));

    // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)

    @Before
    public void before(){
        _allEmployees = new ArrayList<>();
        _allEmployees.add(director);
        _allEmployees.add(manager1);_allEmployees.add(manager2);_allEmployees.add(manager3);
        _allEmployees.add(work1);_allEmployees.add(work2);_allEmployees.add(work3);
        _allEmployees.add(train1);_allEmployees.add(train2);_allEmployees.add(train3);
    }

    @Test
    public void olderThenAndEarnMore(){
        HumanResourceStatistics.olderThenAndEarnMore(_allEmployees,director)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()));
    }
    @Test
    public void practiceLengthLongerThan(){
        HumanResourceStatistics.practiceLengthLongerThan(_allEmployees,30)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()+" "+emp.getSalary()));
    }
    @Test
    public void seniorityLongerThan(){
        HumanResourceStatistics.seniorityLongerThan(_allEmployees,12)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()+" "+emp.bonus()));
    }
    @Test
    public void seniorityBetweenOneAndThreeYears(){
        HumanResourceStatistics.seniorityBetweenOneAndThreeYears(_allEmployees)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()+" "+emp.getSalary()));
    }
    @Test
    public void seniorityLongerThan2(){
        HumanResourceStatistics.seniorityLongerThan(_allEmployees,work2)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()+" "+emp.getSalary()));
    }
    @Test
    public void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(){
        HumanResourceStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(_allEmployees,35)
                .stream()
                .forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getSurname()));
    }

}