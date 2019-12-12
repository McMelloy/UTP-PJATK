import rct.*;
public class RocketMain {
    public static void main(String[] args){
        Rocket a = new Rocket("Rocket1", 0);
        a.refill();
        
        try{
            a.launch();
        }catch(Exception e){
            System.out.println("launch cancelled, fuel too low");
        }
    }
}