package classes;

import java.util.Date;
import java.util.Objects;

public class Teacher extends Person implements Comparable<Person> {

    private Date _hireDate;
    private Degree _degree;

    public Teacher(String firstName, String lastName, Date dateOfBirth, Nationality nationality, Date hireDate, Degree degree,int pesel){
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
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(_hireDate, teacher._hireDate) &&
                _degree == teacher._degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _hireDate, _degree);
    }


}
