import javax.swing.JOptionPane;
public class Quadr{
     public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog(null, "Enter a");
        String s2 = JOptionPane.showInputDialog(null, "Enter b");
        String s3 = JOptionPane.showInputDialog(null, "Enter c");
        double x1;
        double x2;
        int d;
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        if(a=0){
        }
        d = b*b - 4*a*c;
        if( d >= 0){
            x1 = (-b + Math.sqrt(d))/ 2*a;
            x2 = (-b - Math.sqrt(d))/ 2*a;
            JOptionPane.showMessageDialog(null, x1 + " " + x2);
        } else
        JOptionPane.showMessageDialog(null, "There are no roots ");
    }
}