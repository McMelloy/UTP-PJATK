public class TooBigSquareException extends Exception{
    public String msg;
    public TooBigSquareException(String msg){
        super(msg);
    }
}