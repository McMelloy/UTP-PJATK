import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        /*String text = "FF";
        System.out.println(text.matches("[A-Z].*"));//name
        System.out.println(text.matches("\\+\\d{12}"));//telephone
        System.out.println(text.matches("[a-z0-9]+@[a-z]+\\.(com)|(ru)"));//email
        System.out.println(text.matches("(\\d+)|([0-9A-F]+)"));//Number
        String text2 = "That way  of writing , isn 't quite good..'";
        text2 = text2.replaceAll("  "," ");
        text2 = text2.replaceAll(" ,",",");
        text2 = text2.replaceAll(" '","'");
        text2 = text2.replaceAll("\\.\\.'","...");
        System.out.println(text2);*/

        String text3 = "189aaaa 1902aa";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text3);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}