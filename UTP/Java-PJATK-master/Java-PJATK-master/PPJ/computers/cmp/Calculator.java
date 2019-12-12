package cmp;
public class Calculator extends CalculatingMachine {
    public Calculator(String s){
        super (s);
    }
    @Override
    public String calculate(double x, double y) {
       return  super.calculate(x,y) + "'-'" + (x-y) +";";
    }
}