package perpkg;
public class Person {
    protected int name;
    protected int yearOfBirth;
    public Person(int name, int yearOfBirth){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge(){
        return 2018 - yearOfBirth;     
    }

    @Override
    public String toString(){
        return name +" "+yearOfBirth;
    }
}