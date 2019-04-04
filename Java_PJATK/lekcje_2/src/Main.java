import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

class Student implements Comparable<Student>{
    protected String name;
    protected int number;

    public Student(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String toString(){
        return name + " " + number;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number &&
                Objects.equals(name, student.name);

        //return super.equals(o);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(name, number);
        return 17*this.name.hashCode() + number;
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("compareTo");
        int res = this.name.compareTo(o.name);
        if(res == 0)
            return this.number - o.number;
        return res;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Student s0534 = new Student("Tom", 534);

        ArrayList<Student> al = new ArrayList<>();
        al.add(s0534);
        HashSet<Student> hs = new HashSet<>(al);
        TreeSet<Student> ts = new TreeSet<>(al);

        System.out.println(al.contains(s0534));
        System.out.println(hs.contains(s0534));
        System.out.println(ts.contains(s0534));
    }
}
