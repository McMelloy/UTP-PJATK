package extensions;

import classesAndEnum.Nationality;
import classesAndEnum.Teacher;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class TeacherExt {
    private HashSet<Teacher> teacherHashSet = new HashSet<Teacher>();

    public TeacherExt(List<Teacher> list){
        teacherHashSet.addAll(list);
    }

    public void addToPersonHashSet(Teacher e) {
        teacherHashSet.add(e);
    }

    public HashSet<Teacher> getTeacherHashSet() {
        return teacherHashSet;
    }

    public List<Teacher> sort() {
        List<Teacher> temp = new ArrayList<>(teacherHashSet);
        Collator coll = Collator.getInstance(new Locale("pl"));
        temp.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return temp;
    }

    public List<Teacher> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Teacher> p = new ArrayList<>(teacherHashSet);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public List<Teacher> sortByLocale(Nationality nationality) {
        List<Teacher> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage()));
        filtered.sort((o1, o2) -> {
            if (coll.compare(o1.get_lastName(),o2.get_lastName()) !=0)
                return coll.compare(o1.get_lastName(),o2.get_lastName());
            return coll.compare(o1.get_firstName(),o2.get_firstName());
        });
        return filtered;
    }
}
