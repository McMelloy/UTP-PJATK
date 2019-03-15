/**
 * @author s19136
 * @group 18c
 * @blockchainHash 34d2b78c759899c802ced22a6af420999abf617918ffae6c20ad9c0db376f0a2
 */
public class Class16_18c_s19136{
    public static void main(String[] args) {

        int amountOfHorcruxes = 8;
        Voldemort youKnowWho = new Voldemort(amountOfHorcruxes);

        String name = "Harry";
        String familyName = "Potter";
        RegularPerson harry = youKnowWho.killLily(); // Prints something sad

        Dumbledore albus = new Dumbledore();
        Wizard harryWizard = albus.youAreWizard(harry);

        while (youKnowWho.isAlive()) {
            harryWizard.destroyHorcruxOf(youKnowWho);
            harryWizard.tryToDefeat(youKnowWho); // Success, if Voldemort has no Horcruxes
        }

        System.out.println("Happy ending");

    }

}

class Voldemort{
    int horcruxes;
    Voldemort(int n){
        horcruxes = n;
        System.out.println("Voldemort appears, he has "+n+" Horcruxes");
    }
    public boolean isAlive(){
        if(horcruxes<0) {
            System.out.println("Voldemort has died... Harry. You're killer now.");
            return false;
        }
        else
            return true;
    }
    public RegularPerson killLily(){
        System.out.println("Lily ded ;_;");
        RegularPerson harry = new RegularPerson("Harry", "Potter");
        return harry;
    }
}
class RegularPerson{
    String name;
    String familyName;
    RegularPerson(String n, String fn){
        name = n;
        familyName = fn;
        System.out.println(name+" "+familyName+" is born");
    }
}
class Dumbledore{
    String name;
    String familyName;
    Dumbledore(){
        name = "Albus";
        familyName = "Dumbledore";
        System.out.println("Dumbledore appears");
    }
    public Wizard youAreWizard(RegularPerson p){
        Wizard w = new Wizard(p);
        System.out.println(p.name+" "+p.familyName+", you are Wizard");
        return w;
    }
}
class Wizard{
    String name;
    String familyName;
    Wizard(RegularPerson p){
        name = p.name;
        familyName = p.familyName;
    }
    public void destroyHorcruxOf(Voldemort tom){
        tom.horcruxes--;
        System.out.println("Voldemort now has "+tom.horcruxes+" Horcruxes");
    }
    public void tryToDefeat(Voldemort tom){
        if(tom.horcruxes==0)
            tom.horcruxes--;
    }
}