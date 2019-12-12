package classesAndEnum;

import java.util.Locale;
import java.util.Random;

public enum Nationality {
    POLISH("PL"),
    BELARUSIAN("BY"),
    UKRAINIAN("UA"),
    SLOVAK("SK"),
    LATVIAN("LV"),
    BRITISH("GB"),
    INDIAN("IN"),
    CHINESE("ZH"),
    VIETNAMESE("VN");

    private final Locale _locale;

    Nationality(String locale) {
        _locale = new Locale(locale);
    }

    public Locale get_locale() {
        return _locale;
    }

    public static Nationality giveRand() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
