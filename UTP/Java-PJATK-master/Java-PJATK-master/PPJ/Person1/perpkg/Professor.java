package perpkg;
public class Professor extends Person {
    private int id;
    public Professor(int name, int yearOfBirth, int id){
        super(name, yearOfBirth);
        this.id = id;
    }
}