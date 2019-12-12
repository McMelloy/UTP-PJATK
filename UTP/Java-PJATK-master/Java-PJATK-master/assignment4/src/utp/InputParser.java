package utp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

    // 1. Use regular expresssions (Pattern) for validating input data

    //
    // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"

    public static BufferedReader reader;
    //private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    //private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern FULL = Pattern.compile("([a-zA-Z]+) ([a-zA-Z]+) (\\d{4}-\\d{2}-\\d{2})");

    public static List<Person> parse(File file) {
        List<Person> people = new ArrayList<>();
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));

//            while((line = reader.readLine())!= null) {
//                String[] arr = line.split(" ");
//                if(NAME_PATTERN.matcher(arr[0]).matches()
//                        && NAME_PATTERN.matcher(arr[1]).matches()
//                        && DATE_PATTERN.matcher(arr[2]).matches()) {
//                    people.add(new Person(arr[0],arr[1], parseDate(arr[2])));
//                    }
//
//            }

            Matcher fullMatch;
            while((line = reader.readLine())!= null) {
                fullMatch = FULL.matcher(line);
                if(fullMatch.matches()){
                    people.add(new Person(fullMatch.group(1), fullMatch.group(2), parseDate(fullMatch.group(3))));
                }

            }
        } catch(IOException e) {
            System.out.println(e);
        }

        return people;
    }

    public static Date parseDate(String input) {
        Date d = null;
        try {
             d = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return d;
    }

}