package classesAndEnum;

import java.util.List;
import java.util.Objects;

public class Department implements Comparable<Department>{
    private String _department;
    private List<Teacher> employee;

    public Department(String _department, List<Teacher> employee) {
        this._department = _department;
        this.employee = employee;
    }

    public String get_department() {
        return _department;
    }

    public List<Teacher> getEmployee() {
        return employee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_department, employee);
    }

    @Override
    public boolean equals(Object o) {
        Department that = (Department) o;
        return _department == that._department &&
                employee.equals(that.employee);
    }

    @Override
    public int compareTo(Department o) {
        return _department.compareTo(o.get_department());
    }

    @Override
    public String toString() {
        String res = "";
        for(Teacher t:employee)
            res+= t.toString() + "\n";
        return _department + "\nEmployees:\n" + res;
    }
}
