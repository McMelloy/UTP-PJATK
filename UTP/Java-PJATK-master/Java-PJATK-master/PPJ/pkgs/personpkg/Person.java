package personpkg;
import carpkg.*;
public class Person{
    private String name;
    private Car car;

    public Person(String name, Car car){
        this.name = name;
        this.car = car; 
    }
    public Car carGet() {
        return car;
    }
    public String personGet() {
        return name;
    }

    public static Car[] getCars(Person[] arr){
        Car[] brr = new Car [arr.length];
        for(int i = 0; i < arr.length; i++){
            brr[i] = arr[i].carGet();
        }
        return brr;
    }

    public static Car[] expensiveCars(Person[] arr, int a){
        Car[] crr = new Car[arr.length];
        int count = 0;
        for( int i = 0; i< arr.length; i++){
            if(arr[i].carGet().getPrice() >= a){
            crr[i] = arr[i].carGet();
            count++;
            }
        }
        if (count < 0){
            return null;
        }
        return crr;
        

    }
    @Override
    public String toString() {
        return "Car name: " + carGet().getMake() + " " + "car price: " + carGet().getPrice() ; 
    }
}