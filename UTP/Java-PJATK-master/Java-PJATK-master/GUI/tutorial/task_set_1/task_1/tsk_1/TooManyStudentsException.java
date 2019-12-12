package tsk_1;
public class TooManyStudentsException extends Exception{
    public String msg;

    public TooManyStudentsException(String msg){
        super(msg);
    }
}