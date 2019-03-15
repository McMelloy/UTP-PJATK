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
        Path filein = Paths.get("in.txt");
        BufferedReader br = Files.newBufferedReader(filein);
        String line;
        while ( (line = br.readLine()) != null) {
            if (line.matches("[A-Z][a-z]+")){
                System.out.println(line);
            }
        }
    }
}
