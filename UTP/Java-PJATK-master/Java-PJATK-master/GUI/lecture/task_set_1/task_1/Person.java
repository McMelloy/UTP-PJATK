public class Person {
    
    private String name;
    private Car cars;

    public Person(String name) {
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

    public void showCars() {
        this.cars.showCars();
    }

    public void showCarsRev() {
        this.cars.showCarsRev();
    }

    public int getTotalPrice() {
        int tot = 0;
        Car t = cars;
        while(t != null) {
            tot += t.getPrice();
            t = t.getNext();
        }
        return tot;

    }

    public boolean hasCar(String make) {
        boolean has = false;
        Car t = cars;
        while(t != null){
            if(make.equals(t.getMake().toLowerCase())){
                has = true;
            }

            t = t.getNext();
        }
        return has;
    }

    public Car mostExpensive() {
        Car most = cars;
        
        while(cars.getNext() != null){
            if (cars.getNext().getPrice() > cars.getPrice()){
                most = cars.getNext();
            }       

            cars = cars.getNext();
        }
        return most;
    }

    
}