package generators;

import classesAndEnum.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Generator {

    public Teacher generateTeacher(){
        Random r = new Random(); GenNames gn = new GenNames(); GenDate gd = new GenDate();

        Nationality nat = Nationality.giveRand();
        Date birth = gd.generateDateOfBirth();

        return new Teacher(
                GenNames.giveName(nat.toString()),
                GenNames.giveSurname(nat.toString()),
                birth,
                nat,
                gd.generateDateOfEmployment(),
                Degree.values()[r.nextInt(Degree.values().length)],
                GenPesel.genPesel(birth));
    }

    public Student generateStudent(){
        Random r = new Random(); GenNames gn = new GenNames(); GenDate gd = new GenDate();

        Nationality nat = Nationality.giveRand();
        Date birth = gd.generateDateOfEmployment();

        return new Student(
                GenNames.giveName(nat.toString()),
                GenNames.giveSurname(nat.toString()),
                birth,
                nat,
                GenPesel.genPesel(birth),
                r.nextInt(10000)+10000);
    }

    static private int counterGroup=0;
    static List<Student> inGroup = new ArrayList<>();
    static Random random = new Random();

    public StudentGroup genGroup(List<Student> students){
        List<Student> toGroup = new ArrayList<>();
        for(int i=0;i<8;i++){
            int r = random.nextInt(students.size());
            while(inGroup.contains(students.get(r)))
                r = random.nextInt(students.size());
            toGroup.add(students.get(r));
            inGroup.add(students.get(r));
        }
        return new StudentGroup(String.valueOf(counterGroup++),toGroup);
    }

    static private int counterDep=0;
    static List<Teacher> inDep = new ArrayList<>();

    public Department genDep(List<Teacher> teachers){
        List<Teacher> toDep = new ArrayList<>();
        for(int i=0;i<3;i++){
            int r = random.nextInt(teachers.size());
            while(inDep.contains(teachers.get(r)))
                r = random.nextInt(teachers.size());
            toDep.add(teachers.get(r));
            inDep.add(teachers.get(r));
        }
        return new Department("Department "+(counterGroup++),toDep);
    }

    static private int counterSubj=0;
    public Subject genSubj(List<Department> deps, List<Student> students){
        Department superDept = deps.get(random.nextInt(deps.size()));
        List<Student> forSubj = new ArrayList<>();
        for(int i=0;i<12;i++)
            forSubj.add(students.get(random.nextInt(students.size())));
        return new Subject("Subject "+(counterSubj++)
                ,superDept
                ,superDept.getEmployee().get(random.nextInt(superDept.getEmployee().size()))
                ,forSubj);
    }

}
