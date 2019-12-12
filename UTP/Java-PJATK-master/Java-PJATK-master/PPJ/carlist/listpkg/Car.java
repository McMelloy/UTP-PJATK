package listpkg;
public class Car {
    private String make;
    private int price;
    private Car next;

    public Car(String make,int price,Car next){
        this.make = make;
        this.price = price;
        this.next = next;
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
    public Car getNext(){
        return next;
    }
    
    public void showCars(){
        Car tmp = this;
        while(tmp != null){
            System.out.print(tmp+" ");
            tmp = tmp.getNext(); 
        }
        
    }

    public void showCarsRev(){
        Car a = this;
        showRev(a);
    }

    public void showRev(Car a){
        if (a.getNext() != null) showRev(a.getNext()); 
        System.out.print(a+" ");
    }

    @Override
    public String toString(){
        return make +" "+"(" +price+")";
    }
}

