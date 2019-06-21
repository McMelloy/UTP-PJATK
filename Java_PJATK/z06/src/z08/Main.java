package z08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame{
    public static void main(String[] args) {
        // write your code here
        new Main("z08");
    }


    public Main(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(new MyBorder());
        add(new MyGrid());
        setSize(400,250);
        setVisible(true);
    }
}