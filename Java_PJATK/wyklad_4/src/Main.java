import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame{

    public static void main(String[] args) {
	// write your code here
        new Main();
    }

    public Main(){
        setSize(640,480);
        setVisible(true);
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }
}
