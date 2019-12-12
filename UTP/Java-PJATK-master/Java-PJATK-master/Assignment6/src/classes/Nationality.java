package classes;

import java.util.Locale;
import java.util.Random;

public enum Nationality {
    POLISH("PL"),
    BELARUSSIAN("BY"),
    UKRANIAN("UA"),
    SLOVAK("SK"),
    LITHUANIAN("LT"),
    LATVIAN("LV"),
    BRITISH("GB"),
    INDIAN("IN"),
    VIETNAMESE("VN"),
    JAPANESE("JP");

    private final Locale _locale;

    Nationality(String locale) {
        _locale = new Locale(locale);
    }

    public Locale get_locale() {
        return _locale;
    }

    public static Nationality rand() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
