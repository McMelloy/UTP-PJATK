package listpkg;
public class Person {
    private String name;
    private Car cars;

    public Person(String name){
       this.name = name;
       cars = null;
    }

    public Person buys(String make, int price){
        cars = new Car(make, price, cars); 
        return this;
    }

    public String getName(){
        return name;
    }

    public void showCars(){
        cars.showCars();
    }

    public void showCarsRev(){
        cars.showCarsRev();
    }

    public int getTotalPrice(){
        int tot = 0;
        Car tmp = cars;
        while(tmp != null){
            tot+= tmp.getPrice();
            tmp = tmp.getNext(); 
        }
        return tot;
    }
    public boolean hasCar(String make){
        Car tmp = cars;
        boolean has = false;
        while(tmp != null){
            if (make.equalsIgnoreCase(tmp.getMake())){
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public Car mostExpensive(){
        Car max = cars;
        Car tmp = cars.getNext();
        while(tmp != null){
            max = (max.getPrice() > tmp.getPrice()) ? max : tmp; 
            tmp = tmp.getNext(); 
        }
        return max;
    }

}