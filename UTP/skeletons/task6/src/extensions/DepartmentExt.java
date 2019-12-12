package extensions;

import classesAndEnum.Department;

import java.util.HashSet;

public class DepartmentExt {
    public static HashSet<Department> depHashSet = new HashSet<Department>();

    public void addToPersonHashSet(Department e) {
        depHashSet.add(e);
    }
}
