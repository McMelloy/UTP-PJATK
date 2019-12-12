// QKM-ThreadSusp/Frames.java
 
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frames extends JFrame {

    public static void main(String[] args) {
        new Frames();
    }

    public Frames() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Panels");
        setResizable(false);

        OurPanel panel = new OurPanel();
        add(panel,BorderLayout.CENTER);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
