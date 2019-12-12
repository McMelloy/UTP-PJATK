package classesAndEnum;

import java.util.Date;
import java.util.Objects;

public class Student extends Person implements Comparable<Person> {

    private int _studentID;

    public Student(String firstName, String lastName, Date dateOfBirth, Nationality nationality, String pesel,int studentID){
        super(firstName, lastName, dateOfBirth, nationality, pesel);
        _studentID = studentID;
    }

    public int get_studentID() {
        return _studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _studentID);
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return _studentID == student._studentID;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", StudentID=" + _studentID;
    }
}
