import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    int num;
    MyColorPanel mcp;
    public MyButton(String label, int num, MyColorPanel mcp){
        super(label);
        this.num = num;
        this.mcp = mcp;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click "+num);
        mcp.setBackground(Color.RED);
    }
}
