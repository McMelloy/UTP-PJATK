package FileDisplayer;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class Main{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Thread(()->{
            FileDisplayer reader = new FileDisplayer();
        }));
    }
}

class FileDisplayer extends JFrame implements ActionListener{
    
    public static final long serialVersionUID = 90000;

    private JLabel fileNameLabel;
    private JTextArea textarea;
    private JButton openFileButton;
    private JButton exitButton;
    private JFileChooser fc = new JFileChooser();

    FileDisplayer(){

        JFrame window = new JFrame("FileReader");
        
        fileNameLabel = new JLabel("No File Choosen");
        textarea = new JTextArea();
        openFileButton = new JButton("Select file");
        exitButton = new JButton("quit");
        JPanel top = new JPanel();
        JScrollPane middle = new JScrollPane(textarea);
        JPanel bottom = new JPanel();

        textarea.setEditable(false);

        openFileButton.addActionListener(this);
        exitButton.addActionListener(this);

        window.setLayout(new BorderLayout());

        top.add(fileNameLabel);

        window.add(top, BorderLayout.NORTH);
        window.add(middle, BorderLayout.CENTER);

        bottom.add(openFileButton);
        bottom.add(exitButton);
        window.add(bottom, BorderLayout.SOUTH);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 800);
        window.pack();
        window.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        FileNameExtensionFilter fileter = new FileNameExtensionFilter("TEXT FILES", "txt","text");
        fc.setFileFilter(fileter);
        if (e.getSource() == openFileButton) {
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
            
                if(file.exists() && !file.isDirectory() && file.canRead()){
    
                    try{

                        BufferedReader reader = new BufferedReader(new FileReader(file));

                        textarea.setText("");
                        textarea.read(reader, null);

                        reader.close();

                    }catch(IOException x){
                        textarea.setText(x.getMessage());
                    }

                }else{
                    textarea.setText("cannot open file!\n");
                }

                fileNameLabel.setText(file.getName());
            } else {
                fileNameLabel.setText("No File Choosen");
                textarea.setText("");
            }
        }else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
