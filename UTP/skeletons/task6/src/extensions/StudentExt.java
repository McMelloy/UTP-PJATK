package extensions;

import classesAndEnum.Nationality;
import classesAndEnum.Student;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class StudentExt {

    public static HashSet<Student> studentHashSet = new HashSet<Student>();

    public StudentExt(List<Student> list){
        studentHashSet.addAll(list);
    }

    public void addToPersonHashSet(Student e) {
        studentHashSet.add(e);

    }

    public static HashSet<Student> getStudentHashSet() {
        return studentHashSet;
    }

    public List<Student> sort() {
        List<Student> temp = new ArrayList<>(studentHashSet);
        Collator coll = Collator.getInstance(new Locale("pl"));
        temp.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return temp;
    }

    public List<Student> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Student> p = new ArrayList<>(studentHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public List<Student> sortByLocale(Nationality nationality) {
        List<Student> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        filtered.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return filtered;
    }
}
