import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

class Car{
    String name;
    Color color;
    public Car(String name, Color color){
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return name + " " + color.toString();
    }
}
class Person{
    String name;
    int year;
    Car car;

    public Person(String name, int year, Car car) {
        this.name = name;
        this.year = year;
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return year == person.year &&
                Objects.equals(name, person.name) &&
                Objects.equals(car, person.car);
    }

    @Override
    public String toString() {
        String res =  "Name: "+name+"\nYear: "+year;
        if(car!=null){
            res = res + "\nCar: "+car+"\n";
        }
        else{
            res = res + "\nHas no car\n";
        }
        return res;
    }
}
public class Main {

    public static List<Car> findAllCars(List<Person> list){
        List<Car> res = new ArrayList<>();
        for(Person p: list){
            if(p.car!=null)
                res.add(p.car);
        }
        return res;
    }
    public static List<Person> findOwners(List<Person> list, String carName){
        List<Person> res = new ArrayList<>();
        for(Person p: list){
            if(p.car!=null && p.car.name.equals(carName))
                res.add(p);
        }
        return res;
    }
    public static Color findColor(List<Person> list, String name, int year){
        for(Person p: list)
            if(p.name.equals(name) && p.year==year){
                if(p.car==null)
                    return null;
                else
                    return p.car.color;
            }
        return null;
    }

    public static void main(String[] args) throws IOException,FileNotFoundException {
	// write your code here
        ArrayList<Person> list = new ArrayList<>();
        System.out.println("Person list:");
        Car car = null;
        BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
        while(true) {
            String str = reader.readLine();
            if(str==null)
                break;
            String[] strs = str.split(" ");
            String name = strs[0];
            int year = Integer.parseInt(strs[1]);
            if(strs.length>2){
                car = new Car(strs[2],
                        new Color(Integer.parseInt(strs[3]),
                                Integer.parseInt(strs[4]),
                                Integer.parseInt(strs[5])));
            }
            else{
                car = null;
            }
            Person pers = new Person(name,year,car);
            System.out.println(pers);
            list.add(pers);
        }
        List<Car> cars = findAllCars(list);
        System.out.println("Car list:");
        for(Car c: cars)
            System.out.println(c);

        List<Person> perss = findOwners(list, "Mercedes");
        System.out.println("\nPersons who own Mercedes list:");
        for(Person p: perss)
            System.out.println(p);

        System.out.println("Color of Dominic's car:");
        Color col = findColor(list, "Dominic",1990);
        System.out.println(col);
    }
}
