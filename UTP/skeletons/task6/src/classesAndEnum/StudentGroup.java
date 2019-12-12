package classesAndEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentGroup implements Comparable<StudentGroup>{
    private String _group;
    List<Student> _students = new ArrayList<>();

    public StudentGroup(String group, List<Student> students){
        _group=group;
        _students=students;
    }

    public String get_group() {
        return _group;
    }

    public List<Student> get_students() {
        return _students;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_group);
    }

    @Override
    public boolean equals(Object o) {
        StudentGroup that = (StudentGroup) o;
        return _group == that._group;
    }

    @Override
    public int compareTo(StudentGroup o) {
        return _group.compareTo(o.get_group());
    }
}
