public class Car {
    private String make; 
    private int price;
    private Car next;

    public Car(String m, int p, Car n) {
        make = m;
        price = p;
        next = n;
    }

    public Car(String make, int price){
        this(make, price, null);
    }

    public String getMake(){
        return make;
    }

    public int getPrice(){
        return price;
    }


    public Car getNext() {
        return next;
    }

    public void showCars(){
        Car c = this;
        System.out.print(c + " ");
        while(c.next != null){
            System.out.print(c.next + " ");
            c = c.next;
        }
        
    }
   

    public void showCarsRev() {
        if(this!= null){
            Car tmp = this;
            tmp = tmp.next;
            showCarsRev();
        }

        System.out.println(this);
    }

    
    @Override 
    public String toString() {
        return make  + "(" + price + ")" ;
    }

}