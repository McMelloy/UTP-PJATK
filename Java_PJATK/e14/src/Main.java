class Patient{
    protected String name;
    protected String illness;
    protected String treatment;
    public Patient(String nam){
        name = nam;
    }
    public String name(){
        return name;
    }
    public String illness(){
        return illness;
    }
    public String treatment(){
        return treatment;
    }
}

class IllHead extends Patient{
    public IllHead(String nam){
        super(nam);
    }
    public String illness(){
        return "Head";
    }
    public String treatment(){
        return "aspirin";
    }
}

class IllLeg extends Patient{
    public IllLeg(String nam){
        super(nam);
    }

    public String illness(){
        return "Leg";
    }
    public String treatment(){
        return "plaster";
    }

}

class IllDyspepsia extends Patient{
    public IllDyspepsia(String nam){
        super(nam);
    }
    public String illness(){
        return "Dyspepsia";
    }
    public String treatment(){
        return "coal";
    }
}

public class Main {
    public static void main(String[] args) {
        Patient[] patients = {
                new IllHead("Johny"),
                new IllLeg("Eddy"),
                new IllDyspepsia("Manny")
        };
        for (Patient p: patients) {
            System.out.println("Patient: " + p.name() + '\n'
                    + "Illness: " + p.illness() + '\n'
                    + "Treatment: " + p.treatment() + "\n\n");
        }
    }
}
