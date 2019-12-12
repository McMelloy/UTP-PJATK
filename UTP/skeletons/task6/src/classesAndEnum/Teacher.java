package classesAndEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Teacher extends Person implements Comparable<Person> {

    private Date _hireDate;
    private Degree _degree;

    public Teacher(String firstName, String lastName, Date dateOfBirth, Nationality nationality, Date hireDate, Degree degree,String pesel){
        super(firstName, lastName, dateOfBirth, nationality, pesel);
        _hireDate = hireDate;
        _degree = degree;

    }

    public Date get_hireDate() {
        return _hireDate;
    }

    public Degree get_degree() {
        return _degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _hireDate, _degree);
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        Teacher teacher = (Teacher) o;
        return Objects.equals(_hireDate, teacher._hireDate) &&
                _degree == teacher._degree;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() +
                ", hireDate=" + dateFormat.format(_hireDate) +
                ", degree=" + _degree;
    }
}
