public class Mobile_phone extends Device implements Call, Text {
    public boolean has_sim = false;
    private String name = "mobile phone";
    public void putSim() {
        has_sim = true;
    }
    
    @Override
    public boolean can_call(){
        if(has_sim){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean can_text(){
        if(has_sim){
            return true;
        }else{
            return false;
        }
    }

    @Override 
    public String toString() {
        return name;
    }
}