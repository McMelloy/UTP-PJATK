
@FunctionalInterface
interface FunDD {
    double fun(double x);
    static double xminim(FunDD f, double a, double b) {
        double step = 1e-5;
        double min = a;
        for(double i = a; i<=b; i+=step)
            if(f.fun(i)<f.fun(min))
                min = i;
        return min;
    }
}

class Parabola implements FunDD{
    double a, b, c;
    Parabola(double A, double B, double C){
        a = A;
        b = B;
        c = C;
    }
    public double fun(double x){
        return a*x*x + b*x + c;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parabola par = new Parabola(1,-1,1.25);
        System.out.println(FunDD.xminim(par, 0, 1));
        FunDD dd = new FunDD() {
            @Override
            public double fun(double x){
                return Math.sqrt(Math.pow(x - 0.75,2)+1);
            }
        };
        System.out.println(FunDD.xminim(dd, 0, 2));
        System.out.println(FunDD.xminim( x -> {
                return x * x * (x - 2);
        }, 0, 2));
    }
}
