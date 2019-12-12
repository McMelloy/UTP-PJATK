import person.*;
public class PersonMain {
    public static void main (String[] args) {
        Person p1 = new Person("alisa", 2000);
        Person p2 = new Person("bob");
        Person p3 = new Person("maha", 2001);
        Person[] brr = {p2, p1, p3};

        System.out.println(p1.getName());
        System.out.println(p2.getName());
        
        System.out.println(p1.getBirthYear());
        System.out.println(p2.getBirthYear());

        System.out.println(p1.isFemale());
        System.out.println(p2.isFemale());

        System.out.println(Person.getOlder(p1,p2));

        System.out.println(Person.getOldest(brr));

        System.out.println(Person.getYoungestFemale(brr));
        
    } 
}