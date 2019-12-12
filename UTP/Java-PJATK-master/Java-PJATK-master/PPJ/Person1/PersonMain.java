import perpkg.*;
public class PersonMain{
    public static void main (String[] args){
        // Student s = new Professor();
        // Professor p = new Student();
        Person sPerson = new Student(1, 1999, 1234);
        Person pPerson = new Professor(2, 1991, 3421);
        //Student personA = new Person(3, 2000);
        //Student personB = new Person(4, 1995);
        System.out.println(sPerson);
        System.out.println(pPerson);
    }
}