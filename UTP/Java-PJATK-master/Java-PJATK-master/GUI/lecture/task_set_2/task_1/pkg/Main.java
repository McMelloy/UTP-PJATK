
public class Main {
    public static void main(String[] args) {
        Parabola p1 = new Parabola(1, -1, 1.25);
        System.out.println(FunDD.xminim(p1, 0 , 1));

        System.out.println(FunDD.xminim(
            new FunDD() {
            @Override
            public double fun(double x) {
                return Math.sqrt(Math.pow(x - 0.75, 2) +1);
            }
            },  0, 2)
        );
        System.out.println(FunDD.xminim(
        (x) -> x*x*(x-2) , 0, 2));
    } 
}