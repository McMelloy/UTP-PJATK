import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.*;
public class Task_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame f = new MyFrame();
            A oval = new A(f);
            //A oval2 = new A(f,512,512,20);
            f.add(oval);
            //f.add(oval2);     
        });
    }
}

class MyFrame extends JFrame {
    public MyFrame(){
        setSize(1024, 768);
        setTitle("Hello, world!");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class A extends JPanel{
    private JFrame f;
    int x, y, rad;
    A(JFrame f) {
        super(new BorderLayout());
        this.f = f;
    }
    A(JFrame f, int x, int y, int rad) {
        super(new BorderLayout());
        this.f = f;
        this.x = x;
        this.y = y;
        this.rad = rad;
    }
    public void paint(Graphics g) {
        super.paint(g);
        
        // We are setting RGB color for drawing
        
        
        // At the point (512, 512) we are drawing an ellipse with dimension 40x40
        // Notice: (0,0) point is located in top left corner of a window
        //g.drawOval(512, 512, 40, 40);
        Graphics2D d2 = (Graphics2D) g;
        int dim = 40;
        Ellipse2D.Double circle = new Ellipse2D.Double((f.getWidth() - dim) / 2, (f.getHeight()-dim)/2, dim, dim);
        //Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 2*rad, 2*rad);
        d2.setColor(new Color(255, 1, 100));
        d2.fill(circle);
    }
}
    
