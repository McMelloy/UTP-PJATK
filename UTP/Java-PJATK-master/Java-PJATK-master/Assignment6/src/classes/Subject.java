package classes;

import java.util.List;
import java.util.Objects;

public class Subject {

    private String name;
    private Department _supervisingDep;
    private Teacher _lecturer;
    private List<Student> _students;

    public String getName() {
        return name;
    }

    public Department get_supervisingDep() {
        return _supervisingDep;
    }

    public Teacher get_lecturer() {
        return _lecturer;
    }

    public List<Student> get_students() {
        return _students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name) &&
                Objects.equals(_supervisingDep, subject._supervisingDep) &&
                Objects.equals(_lecturer, subject._lecturer) &&
                Objects.equals(_students, subject._students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, _supervisingDep, _lecturer, _students);
    }
}
