class Employee{
    String name;
    String lastName;
    int yearOfBirth;
    int salary;
    static int hired=0;
    Employee(String n, String ln, int year, int sal){
        name =n;
        lastName=ln;
        yearOfBirth=year;
        salary=sal;
        hired++;
    }
    @Override
    public String toString(){
        return "Name is "+name+" "+lastName+"\nBorn in "+yearOfBirth+"\nSalary = "+salary;
    }
}
class Pricelist {
    private static Pricelist instance;
    String[] product;
    int[] price;

    private Pricelist () {
        product = new String[3];
        product[0]="Apple";
        product[1]="Guinness";
        product[2]="Book";
        price = new int[3];
        price[0]=2;
        price[1]=6;
        price[2]=17;
    };

    public static Pricelist getInstanceOf() {
        if (instance == null) {
            instance = new Pricelist();
        }
        return instance;
    }

    int getPrice(String p){
        for(int i=0;i<product.length;i++){
            if(product[i].equals(p))
                return price[i];
        }
        return -1;
    }
    void print(){
        for(int i=0;i<product.length;i++){
            System.out.println(product[i]+" - "+price[i]);
        }
    }
}

public class Shop {
    Employee[] emp;
    int index;
    int budget;
    Pricelist pl;
    Shop(){
        emp = new Employee[5];
        index=0;
    }

    void hire(String n, String ln, int year, int sal){
        if(index+1>=emp.length){
            Employee[] tmp = new Employee[emp.length*2];
            for(int i=0;i<emp.length;i++)
                tmp[i]=emp[0];
            emp = tmp;
        }
        emp[index++] = new Employee(n,ln,year,sal);
    }
    void hire(Employee e){
        if(index+1>=emp.length){
            Employee[] tmp = new Employee[emp.length*2];
            for(int i=0;i<emp.length;i++)
                tmp[i]=emp[0];
            emp = tmp;
        }
        emp[index++] = e;
    }

    int paySalary(){
        for(int i=0;i<emp.length;i++)
            budget-=emp[i].salary;
        return budget;
    }
    int increaseBudget(int inc){
        budget+=inc;
        return budget;
    }
    void printEmployees(){
        for(int i=0;i<emp.length;i++)
            System.out.println(emp[i]);
    }
}