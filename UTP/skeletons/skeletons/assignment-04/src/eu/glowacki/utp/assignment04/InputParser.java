package eu.glowacki.utp.assignment04;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public final class InputParser {
	
	// 1. Use regular expresssions (Pattern) for validating input data
	//
	// 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"
	//    SimpleDateFormat format "yyyy-MM-dd"

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//private static final String linePattern =
	//		"[A-Z]([a-z]+)[ ][A-Z]([a-z]+)[ ][1-9][0-9]{3}[-]([0][1-9]|[1][012])[-]([0][1-9]|[12][0-9]|[3][01])";
	private static final String namePattern = "[A-Z]([a-z]+)";
	private static final String yearPattern = "[1-9][0-9]{3}";
	private static final String monthPattern = "([0][1-9]|[1][012])";
	private static final String dayPattern = "([0][1-9]|[12][0-9]|[3][01])";
	private static final String birthdaySeparator = "[-]";
	private static final String separator = "[ ]";
	private static final String birthdayPattern = yearPattern+birthdaySeparator+monthPattern+birthdaySeparator+dayPattern;
	private static final String linePattern = namePattern+separator+namePattern+separator+birthdayPattern;


	public static List<Person> parse(File file) {
		BufferedReader br = null;
		List<Person> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!=null){
				if(line.matches(linePattern)){
					String[] lines = line.split(" ");
					list.add(new Person(lines[0],lines[1],dateFormat.parse(lines[2])));
				}
			}
			br.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
}