abstract public class OnlineGame implements IsGame {
    public boolean isLoggedIn = false;
    abstract boolean login(String name, String password);
    public void play(){
        if(isLoggedIn){
            System.out.println("playing with friends");
        }
    }
}
