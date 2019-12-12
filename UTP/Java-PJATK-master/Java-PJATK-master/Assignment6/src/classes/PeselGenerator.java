package classes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PeselGenerator {

    public static int genPesel(Date p) {

    }

    private String genDate(Date d) {
        LocalDate tmp = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        tmp.getMonthValue();
        tmp.getYear();
        tmp.getYear();
    }

    private int genRandom() {

    }

    private int calculateLast() {

    }
}
