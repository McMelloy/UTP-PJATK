public class Game extends OnlineGame{
    private String name;
    private String password;
    public Game(String name, String password){
        this.name = name;
        this.password = password;
    }
    
    @Override
    public boolean login(String name, String password){

        if(this.name.equals(name) && this.password.equals(password)){
            isLoggedIn = true;
        }
        return isLoggedIn;   
    }

    
}