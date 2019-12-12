public class WrongDeviceException extends Exception{
    
    public String msg;

    public WrongDeviceException(String msg){
        super(msg);
    }
}