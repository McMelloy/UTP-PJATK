package eu.glowacki.utp.assignment01.sample;


import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

import java.util.ArrayList;

class StudGroup{
    String number;

    public StudGroup(String number) {
        if(number==null)
            throw new NullPointerException("Your string 'number' is empty!");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
public class Student implements IAggregable<Student, Integer>, IDeeplyCloneable<Student> {
    String name;
    StudGroup group;
    ArrayList<Integer> marks;
    public Student() {

    }

    public Student(String name, StudGroup group, ArrayList<Integer> marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public StudGroup getGroup() {
        return group;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }


    @Override
    public Integer aggregate(Integer intermediateResult) {
        if(marks.size()==0)
            return null;
        int avg = 0;
        int count = 0;
        for(double i: marks) {
            count++;
            avg += i;
        }
        avg/=count;
        if  (intermediateResult == null)
            return avg;
        else
            return avg + intermediateResult;
    }

    @Override
    public Student deepClone() {
        Student res = new Student(name, null, marks);
        res.group = new StudGroup(group.number);
        return res;
    }

}
