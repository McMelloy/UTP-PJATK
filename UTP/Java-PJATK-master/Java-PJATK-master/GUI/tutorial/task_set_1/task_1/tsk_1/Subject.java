package tsk_1;
import java.util.Arrays;

public class Subject{
    public String name;
    public Person t;
    public Student[] st = new Student[5];
    public int index;

    public Subject(String name){
        this.name = name;
    }
    public void setTeacher(Person a){
        t = a;
    }
    
    public void addStudent(Student a) throws TooManyStudentsException{
       if(index >= st.length){
            throw new TooManyStudentsException("Too many students");
       }else{
           st[index] = a;
           index++;
       }
    }

    public String printArray(){
        String a ="";
        for(int i = 0; i<st.length; i++){
            if(st[i] != null){
                a+= st[i].toString();
            }
            
        }
        return a;
    }

    @Override
    public String toString(){
        return name +", teacher: " + t.name + ", students: " + printArray();
    }
}
