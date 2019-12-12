@FunctionalInterface
    interface FunDD {
        double fun(double x);

    static double xminim(FunDD f, double a, double b) { 
        double step = Math.pow(10, -5);
        double min = f.fun(a);
        double val = a;
        for(double i = a; i <= b ; i+= step){
            if(min > f.fun(i)) {
               min =  f.fun(i);
               val = i;
            }
        }
        return val;
    }


}