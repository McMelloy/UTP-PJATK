class Person{
    String name;
    int yearOfBirth;
    Person(String n, int birth){
        name = n;
        yearOfBirth = birth;
    }
    int getAge(){
       return 2018 - yearOfBirth;
    }
}
class Professor extends Person{
    int salary;
    String subj;
    Professor(String n, int birth, int sal, String sub){
        super(n, birth);
        salary = sal;
        subj = sub;
    }
    int getAge(){
        return 2018 - yearOfBirth;
    }
}
class Student extends Person{
    int number;
    Student(String n, int birth){
        super(n, birth);
    }
    Student(String n, int birth, int num){
        this(n, birth);
        number = num;
    }
    int getAge(){
        return 2018 - yearOfBirth;
    }
    public String toString(){
        return name+" - "+number;
    }
}
public class Main {
    public static void main(String[] args) {
        Person sPerson = new Student("Kolin Fufelshmerz",1971,19981);
        Person pPerson = new Professor("Levakov",666, 0, "Matan");
        System.out.println(sPerson.getAge());
        System.out.println(pPerson.getAge());
        System.out.println(sPerson);
    }//4554617c
}
