package z09;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        // write your code here
        new Main("z09");
    }


    public Main(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new sqr());
        setSize(400,500);
        setVisible(true);
    }
}
