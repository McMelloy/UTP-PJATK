package exc;
public class NotEnoughGas extends Exception{

    private String mes;


    public NotEnoughGas(int a){
        super("Only "+ a + " liters. Must fill the tank\n");
    }
    public String NotEnoughGas(){
        return mes;
    }
}
