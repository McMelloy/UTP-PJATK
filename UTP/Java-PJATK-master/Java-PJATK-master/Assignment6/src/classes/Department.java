package classes;

import java.util.List;
import java.util.Objects;

public class Department {

    private Dep _depatment;
    private List<Teacher> employee;

    public Dep get_depatment() {
        return _depatment;
    }

    public List<Teacher> getEmployee() {
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return _depatment == that._depatment &&
                employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_depatment, employee);
    }
}
