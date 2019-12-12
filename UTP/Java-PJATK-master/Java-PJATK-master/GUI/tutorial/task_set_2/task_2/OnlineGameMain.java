import java.util.Scanner;
public class OnlineGameMain{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game g = new Game("Alice", "123");
        String name = scan.next();
        String pass = scan.next();

        g.login(name, pass);
        g.play();
        scan.close();
    }
    
}