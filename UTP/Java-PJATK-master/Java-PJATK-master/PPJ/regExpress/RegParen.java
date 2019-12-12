import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegParen {
    public static void main (String[] args) {
        String str = "Lisboa (Lisbon , Portugal), " +
                     "Warszawa (Warsaw,  Poland), and " +
                     "Roma (Rome,Italy) ";

        String [] spl = str.split("(?<=\\), )");
        for (String k : spl) {
            Matcher m2 = Pattern.compile("(\\w+)\\s*\\,\\s*(\\w+)").matcher(k);
            m2.find();
            System.out.println((m2.group(2)+" -> "+m2.group(1)));
        }
    }
}