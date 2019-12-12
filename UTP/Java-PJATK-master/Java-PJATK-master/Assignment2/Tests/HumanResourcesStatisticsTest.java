import employee.Employee;
import employee.Manager;
import employee.Trainee;
import employee.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payroll.PayrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


class HumanResourcesStatisticsTest {
    List<Employee> test;


    @BeforeEach
    void before() {
        test = new ArrayList<>();
        Manager e1 = new Manager("Bocley","Wright", LocalDate.of(2000,3,27), new BigDecimal(2000), new BigDecimal(200), LocalDate.of(2017,9,13));
        Manager e2 = new Manager("Kerr","Hill",LocalDate.of(1965,1,8),new BigDecimal(4000),e1, new BigDecimal(300), LocalDate.of(2000,1,10));
        Manager e3 = new Manager("Paula","Davis",LocalDate.of(1993,8,12),new BigDecimal(2500),e1,new BigDecimal(100), LocalDate.of(2013,6,18));
        Manager e4 = new Manager("Kristianna","Phillips",LocalDate.of(1996,1,31),new BigDecimal(2800),e1,new BigDecimal(200), LocalDate.of(2014,5,17));
        Manager e5 = new Manager("Marciano","Smith",LocalDate.of(1977,11,18),new BigDecimal(3950),e2, new BigDecimal(100),LocalDate.of(2000,12,10));
        Manager e6 = new Manager("Robyn","Russell",LocalDate.of(1971,8,10),new BigDecimal(2100),e2, new BigDecimal(100),LocalDate.of(2000,12,10));
        Manager e7 = new Manager("Adah","Brooks",LocalDate.of(1989,5,4),new BigDecimal(4200),e4, new BigDecimal(100),LocalDate.of(2000,12,10));
        Employee e8 = new Worker("Sequoia","Harris",LocalDate.of(1979,9,17),new BigDecimal(5000),e2,new BigDecimal(100),LocalDate.of(2000,12,10));
        Employee e9 = new Worker("Trory","Hall",LocalDate.of(1992,8,20),new BigDecimal(7000),e5,new BigDecimal(100),LocalDate.of(2011,12,10));
        Employee e10 = new Worker("Georgie","Anderson",LocalDate.of(1966,12,23),new BigDecimal(2400),e5 ,new BigDecimal(100),LocalDate.of(2012,12,10));
        Employee e11 = new Worker("Zinovia","Aterson",LocalDate.of(1985,4,14),new BigDecimal(5600),e5,new BigDecimal(100), LocalDate.of(2012,12,10));
        Employee e12 = new Worker("Maverick","Stewart",LocalDate.of(1994,4,12),new BigDecimal(2000),new BigDecimal(100), LocalDate.of(2012,12,10));
        Employee e13 = new Worker("Edyta","Nelson",LocalDate.of(1984,11,8),new BigDecimal(2600),e4,new BigDecimal(100),LocalDate.of(2015,12,10));
        Employee e14 = new Worker("Aries","Cook",LocalDate.of(1972,5,28),new BigDecimal(2300),e7,new BigDecimal(100),LocalDate.of(2012,12,10));
        Employee e15 = new Worker("Elfrida","Brooks",LocalDate.of(1986,5,27),new BigDecimal(1830),e7,new BigDecimal(100),LocalDate.of(2012,12,10));
        Employee e16 = new Trainee("Violeta","Anderson",LocalDate.of(1990,12,25),new BigDecimal(1800),e2, LocalDate.of(2019,6,1),14);
        Employee e17 = new Trainee("Cruz","Wood",LocalDate.of(1958,12,24),new BigDecimal(1700),e6,LocalDate.of(2018,1,15),20);
        Employee e18 = new Trainee("Dale","Walker",LocalDate.of(1997,12,29),new BigDecimal(2220),e6,LocalDate.of(2017,1,13), 200);
        Employee e19 = new Trainee("Beatrice","Bell",LocalDate.of(1962,3,4),new BigDecimal(900),e2, LocalDate.of(2018,3,14),140);
        Employee e20 = new Trainee("Stoke","Cooper",LocalDate.of(1979,9,24),new BigDecimal(930),e4,LocalDate.of(2019,1,15),100);

        test.add(e1);
        test.add(e2);
        test.add(e3);
        test.add(e4);
        test.add(e5);
        test.add(e6);
        test.add(e7);
        test.add(e8);
        test.add(e9);
        test.add(e10);
        test.add(e11);
        test.add(e12);
        test.add(e13);
        test.add(e14);
        test.add(e15);
        test.add(e16);
        test.add(e17);
        test.add(e18);
        test.add(e19);
        test.add(e20);
    }

    @Test
    void payroll() {
        List<PayrollEntry> t = HumanResourcesStatistics.payroll(test);
        double d1 = 2200;

        int d3 = 1800;

        double d2 = 5100;

        assertEquals(d1,t.get(0).get_salaryPlusBonus().doubleValue());
        assertEquals(d2,t.get(7).get_salaryPlusBonus().doubleValue());
        assertEquals(d3,t.get(15).get_salaryPlusBonus().doubleValue());
        assertEquals(test.get(0),t.get(0).get_employee());
        assertEquals(test.get(7),t.get(7).get_employee());
        assertEquals(test.get(15),t.get(15).get_employee());

    }

    @Test
    void subordinatesPayroll() {
        List<PayrollEntry> t = HumanResourcesStatistics.subordinatesPayroll((Manager)test.get(5));
        assertEquals(test.get(16),t.get(0).get_employee());
        assertEquals(test.get(17),t.get(1).get_employee());

        assertEquals(1700,t.get(0).get_salaryPlusBonus().doubleValue());
        assertEquals(2220,t.get(1).get_salaryPlusBonus().doubleValue());

    }

    @Test
    void bonusTotal() {
        double t = HumanResourcesStatistics.bonusTotal(test).doubleValue();
        assertEquals(1900,t);
    }

    @Test
    void longestSen() {
        Employee x = HumanResourcesStatistics.longestSen(test);
        assertEquals(x,test.get(1));
    }

    @Test
    void highest() {
        assertEquals(7000,HumanResourcesStatistics.highest(test));
    }

    @Test
    void highestWithBonus() {
        assertEquals(7100,HumanResourcesStatistics.highestWithBonus(test));
    }

    @Test
    void AEmployee() {
        List<Employee> t = HumanResourcesStatistics.AEmployee((Manager)test.get(4));
        assertEquals(2,t.size());
        assertEquals('A',t.get(0).get_surname().charAt(0));
    }

    @Test
    void earnMore() {
        List<Employee> t = HumanResourcesStatistics.earnMore(test);
        assertEquals(test.size() - 2,t.size());
        assertEquals(test.get(0),t.get(0));
        assertEquals(test.get(17),t.get(17));
    }

    @Test
    void olderThenAndEarnMore() {
        assertEquals(13, HumanResourcesStatistics.olderThenAndEarnMore(test,test.get(0)).size());
    }

    @Test
    void practiceLengthLongerThan() {
        HumanResourcesStatistics.practiceLengthLongerThan(test,31);
        assertEquals(1800,test.get(15).getSalary().intValue());
        assertEquals((int)(930*1.05),test.get(19).getSalary().intValue());
    }

    @Test
    void seniorityLongerThanNum() {
        HumanResourcesStatistics.seniorityLongerThanNum(test, 220);
        Worker i = (Worker)test.get(7);
        Worker k = (Worker)test.get(0);
        assertEquals(new BigDecimal(300), i.getBonus());
        assertEquals(new BigDecimal(200), k.getBonus());
    }

    @Test
    void seniorityBetweenOneAndThreeYears() {
        HumanResourcesStatistics.seniorityBetweenOneAndThreeYears(test);
        assertEquals(new BigDecimal(2000*1.1).intValue(), test.get(0).getSalary().intValue());
    }


    @Test
    void seniorityLongerThan() {
       HumanResourcesStatistics.seniorityLongerThan(test, test.get(8));
       assertEquals(new BigDecimal(7000), test.get(7).getSalary());
    }

    @Test
    void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan() {
        assertEquals(1,HumanResourcesStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(test,23).size());
    }
}