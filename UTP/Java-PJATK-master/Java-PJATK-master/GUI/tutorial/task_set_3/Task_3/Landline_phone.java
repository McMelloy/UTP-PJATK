public class Landline_phone extends Device implements Call{
    private String name = "Landline phone";
   
    @Override
    public boolean can_call() {
        return true;
    }

    @Override 
    public String toString() {
        return name;
    }
}