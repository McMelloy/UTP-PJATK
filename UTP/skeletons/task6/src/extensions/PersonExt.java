package extensions;

import classesAndEnum.Nationality;
import classesAndEnum.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class PersonExt {

    public static HashSet<Person> personHashSet = new HashSet<Person>();

    public void addToPersonHashSet(Person e) {
        personHashSet.add(e);
    }

    public List<Person> sort() {
        List<Person> temp = new ArrayList<>(personHashSet);
        Collator coll = Collator.getInstance(new Locale("pl"));
        temp.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return temp;
    }

    public List<Person> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Person> p = new ArrayList<>(personHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public List<Person> sortByLocale(Nationality nationality) {
        List<Person> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        filtered.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return filtered;
    }

}
