package tsk_1;
public class Person{
    public String name;
    public int age;
    public Student s;

    public Person(String a, int b){
        name = a;
        age = b;
    }

    public Person(Student s){
        this.s = s;
    }

    public void sayHelloTo(Person p){
        System.out.println("Hi "+ p.name + "!");
    }
}
