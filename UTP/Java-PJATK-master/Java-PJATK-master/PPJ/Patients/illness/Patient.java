package illness;
public class Patient{
    private String name;
    private String illness;
    private String treatment;
    public Patient(String a, String b, String c){
        name = a;
        treatment = b;
        illness = c;
    }


    public String name(){
        return name;
    }

    public String illness(){
        return illness;
    }

    public String treatment() {
        return treatment;
    }
}