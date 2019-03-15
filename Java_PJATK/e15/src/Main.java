class CalculatingMachine{
    String name;
    public CalculatingMachine(String n){
        name = n;
    }
    public String calculate(double x, double y){
        String res = name;
        res = res.concat("("+x+","+y+")"+" -> '+':"+(x+y));
        return res;
    }
    public static void printRes(CalculatingMachine[] a, double x, double y){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i].calculate(x,y));
        }
    }
}
class Calculator extends CalculatingMachine{
    public Calculator(String n){
        super(n);
    }
    public String calculate(double x, double y){
        String res = super.calculate(x,y);
        res = res.concat(",'-':"+(x-y));
        return res;
    }
}
class Computer extends Calculator{
    public Computer(String n){
        super(n);
    }
    public String calculate(double x, double y){
        String res = super.calculate(x,y);
        res = res.concat(",'*':"+(x*y));
        res = res.concat(",'/':"+(x/y));
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        CalculatingMachine[] arr = {
                new Computer("Cray"),
                new CalculatingMachine("Abacus"),
                new Calculator("HP")
        };
        CalculatingMachine.printRes(arr, 21, 7);
    }
}