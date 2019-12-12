package pkgbr;
public class ComputerErrorException extends Exception{
    public String msg;
    public ComputerErrorException(String msg){
        super(msg);
    }
}