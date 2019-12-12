package extensions;

import classes.Nationality;
import classes.Person;
import classes.Teacher;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class TeacherExt {
    public static HashSet<Teacher> teacherHashSet = new HashSet<Teacher>();

    public void addToPersonHashSet(Teacher e) {
        teacherHashSet.add(e);

    }

    public void sortHashSet() {
        List<Teacher> temp = new ArrayList<>(teacherHashSet);
        Collator coll = Collator.getInstance(new Locale("pl","PL"));
        Collections.sort(temp, coll);
    }

    public List<Teacher> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Teacher> p = new ArrayList<>(teacherHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public void sortByLocale(Nationality nationality) {
        List<Teacher> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }
}
