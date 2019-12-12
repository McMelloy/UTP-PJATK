package extensions;

import classesAndEnum.StudentGroup;

import java.util.HashSet;

public class StudGroupExt {
    public static HashSet<StudentGroup> studGroupHashSet = new HashSet<StudentGroup>();

    public void addToPersonHashSet(StudentGroup e) {
        studGroupHashSet.add(e);
    }
}
