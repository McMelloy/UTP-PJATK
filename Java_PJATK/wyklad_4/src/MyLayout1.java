import javax.swing.*;
import java.awt.*;

public class MyLayout1 extends JPanel {
    JButton[] buttons;
    public MyLayout1(MyColorPanel mcp){
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());//Flow, Grid, Border

        buttons = new MyButton[10];
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new MyButton("Click me "+i,i,mcp);
            add(buttons[i]);
            /*buttons[i].addActionListener((e)->{
                System.out.println("Click");
            });*/
        }

        /*
        add(buttons[0], BorderLayout.NORTH);
        add(buttons[1], BorderLayout.SOUTH);
        add(buttons[2], BorderLayout.WEST);
        add(buttons[3], BorderLayout.EAST);
        add(buttons[4], BorderLayout.CENTER);
        add(buttons[0], BorderLayout.PAGE_START);
        add(buttons[1], BorderLayout.PAGE_END);
        add(buttons[2], BorderLayout.LINE_START);
        add(buttons[3], BorderLayout.LINE_END);
        add(buttons[4], BorderLayout.CENTER);*/
    }
}
