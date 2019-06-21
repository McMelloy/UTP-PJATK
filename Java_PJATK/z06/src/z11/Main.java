package z11;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Collections;
import java.util.ArrayList;

public class Main extends JFrame{


    public static void main(String[] args) {
        // write your code here
        new Main("z11.1");
    }

    Main (String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        MyModel model = new MyModel(panel);
        JList<String> list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(200,150));
        add(scroll, BorderLayout.CENTER);

        JTextField input_field = new JTextField("");
        input_field.addActionListener(e -> {
            String s = input_field.getText();
            String[] input = s.split(" ");
            if(input[0].equals("add"))
                model.add(input[1]);
            else if(input[0].equals("del"))
                model.remove(input[1]);
            else if(s.equals("quit"))
                System.exit(0);
            input_field.setText("");
        });
        add(input_field, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class MyModel extends AbstractListModel<String> {
    static final long serialVersionUID = 123456L;

    ArrayList<String> data  = new ArrayList<String>();
    Component comp;

    MyModel(Component c) {
        comp = c;
    }

    public void add(String s) {
        if (data.contains(s)) {
            JOptionPane.showMessageDialog(
                    comp, s + " exists", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.add(s);
        Collections.sort(data);
        fireIntervalAdded(this,0,data.size());
    }

    public void remove(String s) {
        if (!data.contains(s)) {
            JOptionPane.showMessageDialog(
                    comp, "No " + s + " in list", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.remove(s);
        //Collections.sort(data);
        fireIntervalRemoved(this,0,data.size());
    }

    @Override
    public String getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public int getSize() {
        return data.size();
    }
}