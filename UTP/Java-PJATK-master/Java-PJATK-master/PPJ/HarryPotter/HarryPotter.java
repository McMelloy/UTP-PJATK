import harry.*;
public class HarryPotter {
    public static void main(String[] args) {
        int amountOfHorcruxes = 8;
        Volendemort youKnowWho = new Volendemort(amountOfHorcruxes);// first object 

        String name = "Harry";
        String familyName = "Potter";

        RegularPerson harry = youKnowWho.killLilly();// Prints something sad
        
        Dumbledore albus = new Dumbledore();
        Wizard harryWizard = albus.youAreWizard(harry);

        while(youKnowWho.isAlive()) {
            harryWizard.destroyHorcruxOf(youKnowWho);
            harryWizard.tryToDefeat(youKnowWho);// success, if Volendemort has no Horcruxes 
        }

        System.out.println("Happy ending");
    }
}