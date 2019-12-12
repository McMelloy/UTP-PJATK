package harry;
public class Volendemort {
    private int amountOfHorcruxes;
    private boolean alive;

    public Volendemort(int a){
        amountOfHorcruxes = a;
        alive = true;
    }

    public void sub(){
        amountOfHorcruxes-- ;
    }
    public RegularPerson killLilly(){
        System.out.println(":(");
        return new RegularPerson();
    }

    public boolean isAlive(){
        return  (amountOfHorcruxes !=0) ? true : false ;
    }
}