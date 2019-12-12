package extensions;

import classes.Nationality;
import classes.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class PersonExt {

    public static HashSet<Person> personHashSet = new HashSet<Person>();

    public void addToPersonHashSet(Person e) {
        personHashSet.add(e);

    }

    public void sortHashSet() {
        List<Person> temp = new ArrayList<>(personHashSet);
        Collator coll = Collator.getInstance(new Locale("pl","PL"));
        Collections.sort(temp, coll);
    }

    public List<Person> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Person> p = new ArrayList<>(personHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public void sortByLocale(Nationality nationality) {
        List<Person> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }

}
