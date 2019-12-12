package exc;
import java.util.Random;
public class Car {
    private int fuel;
    private int km;

    public Car(){
        fuel = 35;
        km = 0;
    }

    public int getFuel(){
        return fuel; 
    }
    Random rand = new Random();
    public void fill(){
        if( Math.random() <= 0.1 ) {
            throw new Explosion();
        }else {
            fuel = rand.nextInt((35 - 15) + 1) + 15;
            km = rand.nextInt((35 - 15) + 1) + 15;
            System.out.println(km+ "km driven "+ fuel+" liters left");
        }
    }

    public void drive100km() throws NotEnoughGas{
        if(fuel < 10){
            throw new NotEnoughGas(this.fuel); 
        }else {
            fuel-=10;
            km+=100;
            System.out.println(km+ "km driven "+ fuel+" liters left");
        }

    }
}