package cmp;
public class CalculatingMachine {
    private String name;

    public CalculatingMachine(String a) {
        name = a;
    }

    public String calculate(double x, double y) {
     
        return "'+':" + (x + y) +";";
    }

    public static void printRes(CalculatingMachine[] a,
                                 double x, double y) {
        for( CalculatingMachine i : a) {
            System.out.println(i.name + "(" +x+","+y+") ->" + i.calculate(x,y));
        }
    }
}