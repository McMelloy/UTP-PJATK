package extensions;

import classes.Nationality;
import classes.Person;
import classes.Student;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class StudentExt {

    public static HashSet<Student> studentHashSet = new HashSet<Student>();
    public void addToPersonHashSet(Student e) {
        studentHashSet.add(e);

    }

    public void sortHashSet() {
        List<Student> temp = new ArrayList<>(studentHashSet);
        Collator coll = Collator.getInstance(new Locale("pl","PL"));
        Collections.sort(temp, coll);
    }

    public List<Student> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Student> p = new ArrayList<>(studentHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public void sortByLocale(Nationality nationality) {
        List<Student> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }
}
