package frt;
public class Fruit{
    private String name;
    private int seedNumber;

    public Fruit(String name, int seedNumber){
        this.name= name;
        this.seedNumber = seedNumber;
    }

    public String getName(){
        return name;
    }
    public int getNumber(){
        return seedNumber;
    }
}