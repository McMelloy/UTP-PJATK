package password;

public class UsernameAlreadyExistsException extends Exception {

    public UsernameAlreadyExistsException(String msg){
        super(msg);
    }

}
