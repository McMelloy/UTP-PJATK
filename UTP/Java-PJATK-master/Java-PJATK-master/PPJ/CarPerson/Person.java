public class Person {
    private String name;
    private Car cars;
    public Person(String name){
        this.name = name;
        cars = null;
    }
    public Person buys(String make, int price){
        Car a = new Car(make, price);
        return this;
    }
    public String getName(){
        return name;
    }
    public void showCars(){
        showCars();
    }
    public void showCarsRev(){
        showCarsRev();
    }
    public int getTotalPrice(){
        
    }
    public boolean hasCar(){

    }
    public Car mostExpensive(){}
}