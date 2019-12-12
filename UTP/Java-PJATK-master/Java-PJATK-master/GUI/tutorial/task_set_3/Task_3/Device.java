/**
 * Device
 */
abstract public class Device {
    public boolean can_text(){
        return false;
    };
    public boolean can_call(){
        return false;
    }
    public boolean has_internet(){
        return false;
    }
    public boolean can_play(){
        return false;
    }

}