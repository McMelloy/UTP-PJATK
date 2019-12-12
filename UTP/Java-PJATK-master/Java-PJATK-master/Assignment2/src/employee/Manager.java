package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Manager extends Worker {

    private ArrayList<Employee> subordinates = new ArrayList<>();
    private ArrayList<Employee> allSub = new ArrayList<>();

    public Manager(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, Manager manager, BigDecimal bonus,
                   LocalDate employementDate) {

        super(firstName, surname, dateOfBirth, salary, manager, bonus, employementDate);

    }

    public Manager(String firstName, String surname, LocalDate dateOfBirth, BigDecimal salary, BigDecimal bonus,
                   LocalDate employementDate) {

        this(firstName, surname, dateOfBirth, salary, null, bonus, employementDate);
    }

    public void addSub(Employee e) {

        subordinates.add(e);
    }

    public ArrayList<Employee> getSubordinates(){
        return subordinates;
    }


    public ArrayList<Employee> getAllSubs() {

        subordinates
                .stream()
                .forEach(emp -> {
                    if (emp instanceof Manager) {
                        allSub.addAll(((Manager) emp).getAllSubs());
                        allSub.add(emp);
                    } else {
                        allSub.add(emp);
                    }
                });

        return allSub;
    }

}