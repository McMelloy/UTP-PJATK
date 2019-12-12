public class Console extends Device implements Game, Internet {
    public boolean has_connection = false;
    private String name = "Console";

    
    public void connect(){
        has_connection = true;
    }

    @Override
    public boolean can_play(){
        if(has_connection) {
            return true;
        } else {
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
    public String toString() {
        return name;
    }
}