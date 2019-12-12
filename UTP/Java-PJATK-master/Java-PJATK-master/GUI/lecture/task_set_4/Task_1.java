import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;
import java.util.TreeSet;
class Person implements Comparable<Person>{
    private String name;
    private int yearOfBirth;
    public Person(String n, int y) {
        name = n;
        yearOfBirth = y;
    }
    public static boolean findInColl(Collection<Person> coll, String name, int year){
        Person tmp = new Person(name, year);
        return coll.contains(tmp);
    }

    //to compare in TreeMap
    @Override
    public int compareTo(Person f) {
        boolean n = name.equals(f.name);
        int diff = yearOfBirth - f.yearOfBirth;

        if ((diff < 0) || !n) {
            return -1;
        }
        else if ((diff > 0)|| !n){
            return +1;
        } 
        else return 0;
    }

    @Override 
    public String toString(){
        return "name: " + name + " yearOfBirth: " + yearOfBirth;
    }

    // to compare different objects with the same instances in HashSet
    @Override
    public int hashCode(){
        return name.hashCode() + new Integer(yearOfBirth).hashCode();
    } 

    // to compare different objects with the same instances
    @Override 
    public boolean equals(Object other){
       if(other == null || getClass()!= other.getClass()) {
           return false;
       }
       Person p = (Person)other;
        return yearOfBirth==p.yearOfBirth && name.equals(p.name);
    }
}

public class Task_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int y;
        String tmp;
        int count = 0;
        ArrayList<Person> list= new ArrayList<Person>();

        //read data

        while(!name.equals("end")){
            //TODO: ecxeption
            tmp = scan.next();

            for(int i = 0; i < tmp.length(); i++){
                if(!Character.isDigit(tmp.charAt(i))){
                    count++;
                }
            }
            
            try {
                if (count != 0){
                    throw new NumberFormatException(); 
                    
                }else {
                    y =  Integer.parseInt(tmp);
                }

                list.add(new Person(name, y));
            
            } catch (Exception e) {
                System.out.println(e);
            }
            count =0;
            name = scan.next();
        }

        //print list
        for (Person a : list) {
            System.out.println(a);
        }

        
        System.out.println(Person.findInColl(list, "alice", 2000));

        //create hashSet
        Set<Person> hSet = new HashSet<>(list);

        System.out.println();

        //print hashSet
        for (Person b : hSet) {
            System.out.println(b);
        }

        System.out.println(Person.findInColl(hSet, "alice", 2000));

        //create TreeSet
        Set<Person> trSet = new TreeSet<>(list);

        for (Person f : list) {
            System.out.println(f);
        }

        System.out.println(Person.findInColl(trSet, "alice", 2000));
    }
}