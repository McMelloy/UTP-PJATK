package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {
	
	// (assignment 02)
	// attributes:
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
    private List<Employee> directSub;

    public Manager(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
                   LocalDate employDate, BigDecimal bonus) {
        super(firstName, surname, birthDate, salary, manager, employDate, bonus);
        directSub = new ArrayList<>();
    }

    public List<Employee> getSub() {
        return directSub;
    }

    public List<Employee> getAllSub() {
        List<Employee> allSub = new ArrayList<>(directSub);
        directSub
                .stream()
                .forEach(emp-> {
                    if (emp instanceof Manager)
                        allSub.addAll(((Manager) emp).getSub());
                });
        return allSub;
    }

    public void addSub(Employee sub){
        directSub.add(sub);
    }
}