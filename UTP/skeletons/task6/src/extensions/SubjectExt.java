package extensions;

import classesAndEnum.Subject;

import java.util.HashSet;


public class SubjectExt {
    public static HashSet<Subject> subjectHashSet = new HashSet<Subject>();

    public void addToPersonHashSet(Subject e) {
        subjectHashSet.add(e);
    }

}


