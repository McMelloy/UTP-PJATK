package cmp;
public class Computer extends Calculator {

    public Computer(String d){
        super(d); 
    }

    @Override
    public String calculate(double x, double y) {
       return  super.calculate(x,y) + "'*'" + (x * y) + ";'/'" + (x / y) +";";
    }
}