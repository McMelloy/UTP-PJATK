package z10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        // write your code here
        new Main("z10");
    }


    public Main(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        this.setLayout(new BorderLayout());
        JLabel nameOfFile = new JLabel("Name of file");
        nameOfFile.setHorizontalAlignment(SwingConstants.CENTER);
        nameOfFile.setSize(getWidth(),(int)(getHeight()*0.2));
        add(nameOfFile, BorderLayout.NORTH);

        JTextArea text = new JTextArea();
        text.setSize(getWidth(),(int)(getHeight()*0.6));
        add(text, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(getWidth(),(int)(getHeight()*0.2));
        buttonPanel.setLayout(new FlowLayout());
        JButton select = new JButton("Select file");
        select.addActionListener(e->{
            text.setText("");
            JFileChooser chooser = new JFileChooser();
            BufferedReader bf = null;
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                try {
                    nameOfFile.setText(f.getName());
                    bf = new BufferedReader(new FileReader(f));
                    String s = bf.readLine();
                    while(s!=null){
                        text.append(s + '\n');
                        s = bf.readLine();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    bf.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));

        buttonPanel.add(select);
        buttonPanel.add(exit);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}