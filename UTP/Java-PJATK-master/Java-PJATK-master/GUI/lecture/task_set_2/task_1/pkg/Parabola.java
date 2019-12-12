
public class Parabola implements FunDD {
    double a, b, c;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double fun(double x) {
        return (x*x) + b*x +c;
    };

}