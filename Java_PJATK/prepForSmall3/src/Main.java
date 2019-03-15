import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.io.InputStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        InputStream is = System.in;
        Path fileOut = Paths.get("out.txt");
        BufferedWriter out = Files.newBufferedWriter(fileOut, UTF_8);
        StringBuilder str = new StringBuilder();
        char c = (char) is.read();
        while(c!='\n') {
            str.append(c);
            c = (char)is.read();
        }
        System.out.println(str);
        Pattern pattern = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            out.write(matcher.group()+'\n');
        }
        out.close();

        /*while(true) {
            if(c>='0' && c<='9') {
                c = (char) is.read();
            }

        }*/

    }
}
