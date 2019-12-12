package classesAndEnum;

import java.util.List;
import java.util.Objects;

public class Subject implements Comparable<Subject>{

    private String _name;
    private Department _superDep;
    private Teacher _lecturer;
    private List<Student> _students;

    public Subject(String _name, Department _superDep, Teacher _lecturer, List<Student> _students) {
        this._name = _name;
        this._superDep = _superDep;
        this._lecturer = _lecturer;
        this._students = _students;
    }

    public String getName() {
        return _name;
    }

    public Department get_supervisingDep() {
        return _superDep;
    }

    public Teacher get_lecturer() {
        return _lecturer;
    }

    public List<Student> get_students() {
        return _students;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _superDep, _lecturer, _students);
    }

    @Override
    public boolean equals(Object o) {
        Subject subject = (Subject) o;
        return Objects.equals(_name, subject._name) &&
                Objects.equals(_superDep, subject._superDep) &&
                Objects.equals(_lecturer, subject._lecturer) &&
                Objects.equals(_students, subject._students);
    }

    @Override
    public int compareTo(Subject o) {
        if(_name.compareTo(o.getName()) != 0 )
            return _name.compareTo(o.getName());
        else if(_superDep.compareTo(o.get_supervisingDep()) != 0)
            return _superDep.compareTo(o.get_supervisingDep());
        else if(_lecturer.compareTo(o.get_lecturer()) != 0)
            return _lecturer.compareTo(o.get_lecturer());
        return 0;
    }

    @Override
    public String toString() {
        return _name +
                "\nsuperDep: " + _superDep.get_department() +
                "\nlecturer: \n" + _lecturer;
    }
}
