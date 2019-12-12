package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	// (assignment 02)
	// attributes:
	// * salary
	// * manager (empty if at top of hierarchy)

	// (assignment 03)
	// methods:
	// * salary is greater than given amount of money
	// * salary is less than given amount of money
	// * compare salary with other employee salary
    private BigDecimal salary;
    Manager manager;

    protected Employee(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager) {
        super(firstName, surname, birthDate);
        this.salary = salary;
        this.manager = manager;
        if(manager!=null) this.manager.addSub(this);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public abstract BigDecimal bonus();

    public abstract int seniority();

    public void raiseSalary(double percent){
        salary = salary.add(salary.multiply(BigDecimal.valueOf(percent)));
    }

    public void raiseSalary(BigDecimal amount){
        salary = salary.add(amount);
    }

    public int compareSalary(Employee other){
        //System.out.println(this.getFirstName()+" "+this.getSurname() +" vs "+other.getFirstName()+" "+other.getSurname());
        //System.out.println(this.getSalary().compareTo(other.getSalary()));
        return this.getSalary().compareTo(other.getSalary());
    }

    public boolean isSalaryGreater(BigDecimal sal){
        return this.getSalary().compareTo(sal)>0;
    }

    public boolean isSalaryLess(BigDecimal sal){
        return this.getSalary().compareTo(sal)<0;
    }
}