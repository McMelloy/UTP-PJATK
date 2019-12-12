public class Smartphone extends Device implements Game, Internet, Call, Text {
    public boolean has_connection = false;
    public boolean has_sim = false;
    private String name = "Smartphone";
    public void connect() {
        has_connection = true;
    }

    public void putSim() {
        has_sim = true;
    }

   
    @Override
    public boolean can_play(){
        if(has_connection){
            return true;
        }else{
            return false;
        }
    }

    @Override 
    public boolean has_internet() {
        if(has_connection) {
            return true;
        } else return false;
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