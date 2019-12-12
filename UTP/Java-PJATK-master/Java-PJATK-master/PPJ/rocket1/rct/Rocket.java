package rct;
import java.util.*;
public class Rocket {
    private String name;
    private int fuelWeight;

    public Rocket(String name, int fuelWeight){
        this.name = name;
        this.fuelWeight = fuelWeight;
    }

    public int refill(){
        Random ran = new Random();
        fuelWeight = ran.nextInt(1000);
        return fuelWeight;
    }

    public void launch() throws Exception{   
           if(fuelWeight <= 1000){
            throw new Exception();
            
    }
}
}
    