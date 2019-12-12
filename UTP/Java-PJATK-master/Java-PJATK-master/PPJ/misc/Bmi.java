import javax.swing.JOptionPane;
public class Bmi {
     public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog(null, "Enter your height in meters");
        String s2 = JOptionPane.showInputDialog(null, "Enter your weight in kilograms");
        double h  = Double.parseDouble(s1);
        double w  = Double.parseDouble(s2);
        double bmi = w/(h*h);
        JOptionPane.showMessageDialog(null, "Your BMI is: "+bmi);
    }
}