package z08;
import javax.swing.*;
import java.awt.*;

public class MyBorder extends JPanel {
    JButton[] buttons;
    public MyBorder(){
        this.setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 4));
        buttons = new JButton[12];
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton("B"+(i+1));
            buttonsPanel.add(buttons[i]);
        }
        add(buttonsPanel,BorderLayout.CENTER);
        add(new JTextArea("JTextArea 1"), BorderLayout.WEST);
        add(new JTextArea("JTextArea 2"), BorderLayout.EAST);
        add(new JTextField("JTextField 4"), BorderLayout.SOUTH);
    }
}