import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name; 
    private int yearOfBirth;
    private Car car;
    public Person(String name, int yearOfBirth, Car car){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.car = car;
    }

    public static List<Car> findAllCars(List<Person> list){
        List<Car> car_person = new ArrayList<>();
        for (Person a : list) {
            if(a.car != null){
                car_person.add(a.car);
            }
        }
        return car_person;
    }

    public static Color findColor(List<Person> list, String name, int year){
        Color clr = null;
        for (Person a : list) {
            if(a.car != null && a.name.equals(name) && a.yearOfBirth == year){
                clr = a.car.color;
            } 
        }
        return clr;
    }

    public static List<Person> findOwners(List<Person> list, String carName){
        List<Person> per_car = new ArrayList<>();
        for (Person a : list) {
            if(a.car != null && a.car.name.equals(carName)){
                per_car.add(a);
            }
        }
        return per_car;
    }

    @Override
    public String toString(){
        return name +" " + yearOfBirth  +" "+car;
    }
}

class Car {
    String name;
    Color color;
    public Car(String name, Color color){
        this.name = name;
        this.color = color;
    }

    public String toString(){
        return name +" color: "+ color.getRed() + " " + color.getGreen() + " " + color.getBlue();
    }
}

public class Task_4 {
    public static void main(String[] args) {

    
        try{
            ArrayList<Person> list = new ArrayList();
            BufferedReader in = new BufferedReader(new FileReader("car.txt"));

            String line;
            while ((line = in.readLine()) != null) {
                String[] columns = line.split(" ");
                int len = columns.length;
                if(len == 2) {
                    list.add(new Person(columns[0], Integer.parseInt(columns[1]), null));
                } else {
                    list.add(new Person(columns[0], Integer.parseInt(columns[1]), new Car(columns[2], new Color(Integer.parseInt(columns[3]), 
                    Integer.parseInt(columns[4]), Integer.parseInt(columns[5])))));
                }
            }

            for (Person a : list) {
                System.out.println(a);
            }

            System.out.println();
        
            for (Car a : Person.findAllCars(list)) {
                System.out.println(a);
            }
            System.out.println();
            System.out.println("Find owners");
            System.out.println();
            for (Person b : Person.findOwners(list, "Mercedes")) {
                System.out.println(b);
            }

            System.out.println(Person.findColor(list, "Alice", 1993));
            
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

        
    

    }
}