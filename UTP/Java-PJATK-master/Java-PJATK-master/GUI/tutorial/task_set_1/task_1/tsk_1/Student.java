package tsk_1;
public class Student extends Person{
    public String name;
   // public int age;
    public int sem;

    public Student (String name, int age, int sem){
        super(name, age);
        this.name = name;
        this.sem = sem;
    } 
    public void sayHelloTo(Student s){
        System.out.println("Yo "+ s.name + "!");
    }

    public void sayHelloTo(Person a){
        System.out.println("Good morning "+ a.name + "!");
    }
    @Override
    public String toString(){
       return name + " - "+ sem + " sem ";
    }
}