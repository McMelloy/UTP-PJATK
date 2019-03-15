class OS{
    String name;
    int version;
    public OS(String n, int v){
        name = n;
        version = v;
    }
    @Override
    public String toString(){
        return name+" of version "+version;
    }
}
class Language{
    String name;
    public Language(String l){
        name=l;
    }
    @Override
    public String toString(){
        return name;
    }
}
class Employee{
    String name;
    int savings;
    public Employee(String n, int s){
        name = n;
        savings = s;
    }
    @Override
    public String toString(){
        return name+" has "+savings+" Nzimbu shells\n";
    }
}
class Programmer extends Employee{
    Language favouriteLanguage;
    int yearsOfExperience;
    public Programmer(String n, int s, String l, int e){
        super(n,s);
        favouriteLanguage = new Language(l);
        yearsOfExperience = e;
    }
    @Override
    public String toString(){
        return "Programmer "+name+" has "+savings+" Pakistani rupee"+"\nHis fav language is "+favouriteLanguage+"\nHe has "+yearsOfExperience+" years of XP\n";
    }
}
class Administrator extends Employee{
    OS favouriteOperatingSystem;
    boolean isWorkingNow;
    public Administrator(String n, int s, String os, int version, boolean w){
        super(n,s);
        favouriteOperatingSystem = new OS(os, version);
        isWorkingNow = w;
    }
    @Override
    public String toString(){
        if(isWorkingNow)
            return "Administrator "+name+" has "+savings+" Zimbabwe dollars"+"\nHis fav OS is "+favouriteOperatingSystem+"\nHe is working now\n";
        else
            return "Administrator "+name+" has "+savings+" Zimbabwe dollars"+"\nHis fav OS is "+favouriteOperatingSystem+"\nHe is not working now\n";
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Programmer jake = new Programmer("Jake",2000,"C#",7);
        System.out.println(jake);
        Administrator luke = new Administrator("Luke", 5000, "Shindows", 6,false);
        System.out.println(luke);
        Employee mark = new Employee("Mark", 69);
        System.out.println(mark);
        OS linux = new OS("Shinux", 1);
        System.out.println(linux);
        Language lang = new Language("LOLCODE");
        System.out.println(lang);
        System.out.println("(This language actually exists)");
    }
}
