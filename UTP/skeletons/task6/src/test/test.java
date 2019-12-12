package test;

import classesAndEnum.*;
import extensions.StudentExt;
import extensions.TeacherExt;
import generators.Generator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    Generator generator = new Generator();
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<StudentGroup> groups = new ArrayList<>();
    List<Department> deps = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();

    @Before
    public void generate(){
        for(int i=0;i<10;i++)
            teachers.add(generator.generateTeacher());

        for(int i=0;i<100;i++)
            students.add(generator.generateStudent());

        for(int i=0;i<12;i++)
            groups.add(generator.genGroup(students));

        for(int i=0;i<3;i++)
            deps.add(generator.genDep(teachers));

        for(int i=0;i<10;i++)
            subjects.add(generator.genSubj(deps,students));

    }

    @Test
    public void printTeachers(){
        for(Teacher t:teachers)
            System.out.println(t);
    }
    @Test
    public void printStudents(){
        for(Student t:students)
            System.out.println(t);
    }

    @Test
    public void printDepartments(){
        for(Department t:deps)
            System.out.println(t);
    }

    @Test
    public void printSubjects(){
        printDepartments();
        for(Subject t:subjects) {
            System.out.println(t);
            System.out.println("Students:");
            for(Student s:t.get_students())
                System.out.println(s);
            System.out.println();
        }
    }

    @Test
    public void sort(){
        printTeachers();
        System.out.println("Sort:");

        TeacherExt ext = new TeacherExt(teachers);
        List<Teacher> sorted = ext.sort();
        for(Teacher t: sorted){
            System.out.println(t);
        }
    }

    @Test
    public void filter(){
        StudentExt ext = new StudentExt(students);

        System.out.println("Filter");
        List<Student> filtered = ext.sortByLocale(Nationality.VIETNAMESE);
        for(Student t: filtered){
            System.out.println(t);
        }
        List<Integer> B = new ArrayList<>();
        B.ge
    }

}
