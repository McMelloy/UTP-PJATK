import javax.swing.JOptionPane;
public class Divisors{
    public static void main(String[] args){
        int pr=2;
        String s="";
        String s1 = JOptionPane.showInputDialog(null, "Enter an integer");
        int n = Integer.parseInt(s1);
        for(int i = 2; i< n; i++){

            if(n % i == 0){
                s+=" "+ i;
            }
            else pr++;
        }
        if(pr==n){
           JOptionPane.showMessageDialog(null, "The number " + n +" is prime");
        }
        else JOptionPane.showMessageDialog(null, "Nontrivial divisors of" + n+":" +s);
       

    }
}