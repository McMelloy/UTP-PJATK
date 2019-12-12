package perpkg;
public class Student extends Person {
    private int studentNum;

    public Student(int name, int yearOfBirth, int studentNum){
        super(name, yearOfBirth);
        this.studentNum = studentNum;
       
    }
    @Override
    public String toString(){
        return super.name +" "+super.yearOfBirth + " " + studentNum;
    }
}