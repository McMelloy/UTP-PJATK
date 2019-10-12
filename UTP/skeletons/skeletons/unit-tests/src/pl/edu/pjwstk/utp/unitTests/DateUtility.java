package pl.edu.pjwstk.utp.unitTests;

import java.util.Calendar;
import java.util.Date;

public final class DateUtility {

	public static int differenceInYears(Date start, Date end) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		int startYear = calendar.get(Calendar.YEAR);
		calendar.setTime(end);
		int endYear = calendar.get(Calendar.YEAR);
		return endYear - startYear;
	}
}