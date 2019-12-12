package classes;

import java.util.Date;
import java.util.Objects;

public class Student extends Person implements Comparable<Person> {

    private int _studentID;

    public Student(String firstName, String lastName, Date dateOfBirth, Nationality nationality, int pesel,int studentID){
        super(firstName, lastName, dateOfBirth, nationality, pesel);
        _studentID = studentID;
    }

    public int get_studentID() {
        return _studentID;
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return _studentID == student._studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _studentID);
    }
}
