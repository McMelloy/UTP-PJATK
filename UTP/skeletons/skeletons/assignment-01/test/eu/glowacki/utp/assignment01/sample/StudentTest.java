package eu.glowacki.utp.assignment01.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    private static final String name = "John";
    private static final String group = "18c";
    static ArrayList<Integer> marks;

    private Student _Student;

    @Before
    public void before() {
        marks = new ArrayList<>();
        marks.add(1);marks.add(3);marks.add(7);marks.add(9);
        _Student = new Student(name, new StudGroup(group),marks);
        Assert.assertEquals(name, _Student.getName());
        Assert.assertEquals(group, _Student.getGroup().number);
        Assert.assertEquals(marks, _Student.getMarks());
    }

    @Test
    public void aggregate() {
        int check = 0;
        int count = 0;
        for(int i=0;i<marks.size();i++, count++)
            check+=marks.get(i);
        check/=count;
        int aggregate = _Student.aggregate(null);
        Assert.assertEquals(check, aggregate);
        final int init = 20;
        Assert.assertEquals((int) (check + init), (int) (_Student.aggregate(init)));
    }

    @Test
    public void deepClone() {
        Student clone = _Student.deepClone();
        Assert.assertEquals(_Student.getName(), clone.getName());
        Assert.assertEquals(_Student.getMarks(), clone.getMarks());

        Assert.assertNotSame(_Student, clone);
        Assert.assertNotSame(_Student.getGroup(), clone.getGroup());

    }
}