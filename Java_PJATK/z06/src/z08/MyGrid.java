package z08;
import javax.swing.*;
import java.awt.*;

public class MyGrid extends JPanel {
    public MyGrid(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        int button=1;
        int y=0;
        JButton[] buttons = new JButton[8];
        for(int q=0;q<4;q++){
            c.gridx = q;
            c.gridy = y;
            c.weightx = 0.5; // important when resizing
            c.weighty = 0.5;
            add(new JButton("B"+button),c);
            button++;
        }

        y++;
        c.gridx=0;
        c.gridy = y;
        c.gridwidth=2;
        c.gridheight=3;
        add(new JTextArea("JTEXT"),c);

        c.gridwidth=2;
        c.gridheight=1;
        for(int q=0;q<3;q++) {
            c.gridx=2;
            c.gridy = y;
            add(new JTextField("JTEXT"),c);
            y++;
        }

        c.gridwidth=1;
        c.gridheight=1;
        for(int q=0;q<4;q++){
            c.gridx = q;
            c.gridy = y;
            add(new JButton("B"+button),c);
            button++;
        }

    }
}
