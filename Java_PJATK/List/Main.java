package List;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Thread(() -> createAndShowGui()));
    }

    private static void createAndShowGui(){
        JFrame window = new JFrame("List");
        window.setLayout(new BorderLayout());

        ListModel list_model = new ListModel();
        JList list = new JList();
        JScrollPane panel = new JScrollPane(list);
        JTextField input_field = new JTextField("type command and name...");

        list.setModel(list_model);

        window.add(panel, BorderLayout.CENTER);
        window.add(input_field, BorderLayout.SOUTH);

        input_field.addActionListener(list_model);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}

class ListModel extends AbstractListModel implements ActionListener {

    ArrayList<String> elements = new ArrayList<>();

    public ListModel(){}

    public int getSize() {
        return elements.size();
    }

    public Object getElementAt(int index) {
        return elements.get(index);
    }

    public void actionPerformed(ActionEvent e) {
        JTextField origin = (JTextField)e.getSource();
        String[] input = origin.getText().split(" ");

        origin.setText("");

        if(input.length == 1){
            if(input[0].equals("print")){
                print();
            } else if(input[0].equals("quit")){
                quit();
            }
        }

        if(input.length != 2 || input[0] == null || input[0].isEmpty()){
            return;
        }

        if(input[0].equals("add")){
            if(!add(input[1])){
                JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel,
                "Element already exist!",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);
            }
        } else if(input[0].equals("del")){
            if(!remove(input[1])){
                JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel,
                "Element does not exist!",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public boolean add(String el){
        System.out.println("adding " + el);

        if(elements.contains(el)){
            return false;
        }

        if(!elements.add(el)){
            return false;
        }
        fireContentsChanged(this, 0, elements.size());
        fireIntervalAdded(this, 0, elements.size());
        return true;
    }
    public boolean remove(String el){
        System.out.println("removing " + el);

        if(!elements.remove(el)){
            return false;
        }
        fireContentsChanged(this, 0, elements.size());
        fireIntervalRemoved(this, 0, elements.size());
        return true;
    }

    private void print(){
        System.out.println("List contents:");
        for (String el : elements) {
            System.out.println("  " + el + ",");
        }
        System.out.println();
    }

    private void quit(){
        System.exit(0);
    }

}
