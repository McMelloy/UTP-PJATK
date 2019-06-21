import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyJFrame extends JFrame {

    public static void main(String[] args) {
        // write your code here
        SwingUtilities.invokeLater(
                ()->{
                    new MyJFrame();
                }
        );
    }

    MyColorPanel mcp;

    public MyJFrame(){
        /*this.setLayout(null);

        JButton jb = new JButton("Click me");
        jb.setSize(100,20);
        add(jb);

        JButton jb1 = new JButton("Click me1");
        jb1.setSize(100,20);
        jb1.setLocation(50,100);
        add(jb1);
        */
        mcp = new MyColorPanel();
        mcp.setBackground(Color.CYAN);
        add(new MyLayout1(mcp));
        setSize(640,480);
        setVisible(true);

    }
}
