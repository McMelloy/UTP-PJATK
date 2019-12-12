public abstract class Lab implements SthToGrade {
    List<Integer> students;

    
    public Lab() {
        students = new ArrayList<>();
    }

    @Override
    public void addStudent(int index) {
        if(students.size() < MAX){
            students.add(index);
        }
    }

    abstract void checkList();
}