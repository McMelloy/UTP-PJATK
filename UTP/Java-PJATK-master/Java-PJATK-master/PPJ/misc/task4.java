

public static class task4{
    public static void main(String[] args){
        Frac a = new Frac(20,4),   b = new Frac(1,-2),
         c = new Frac(-14,-4), d = new Frac(-8,-4),
         f = new Frac(4),      m = new Frac(-1);
        Frac f2 = Frac.add(Frac.mul(d,c),
                       new Frac(10).mul(b));
        Frac f4 = Frac.add(Frac.mul(Frac.mul(a,b),
                       new Frac(-2)),m);
        Frac zz = d.add(a).add(f.mul(Frac.mul(b,c)));
        Frac ww = Frac.div(f2,f4).sub(b).sub(c);
        System.out.println(f2 + " " + f4 + " " +
                       zz + " " + ww);
        
        
       
    }
}

public class Frac {
    private int num;
    private int denom;
    public Frac(int num, int denom) {

        //if has common factors throw whole number exeption
        
        try { 
            if (denom <= 0){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid demominator, should be greater than 0");
        }
        // num ? denom ->> min
        if ((gcdThing(num, denom))!= (num < denom ? num : denom)) {// simplify
            this.num = num;
            if (num == 0) {
                this.denom = 1;
            } else {
                this.denom = denom;
            }
        } else {
            int g = gcdThing(num, denom);
            num = num/g; 
            denom = denom/g;   
        }  
    }

    public Frac(int num){
        try {
            Frac(num, 1);
        } catch (Exception e) {
            System.out.println("invalid numerator");
        }
        Frac(num, 1);
    }

    public Frac(){
        Frac(0,1);
    }

    private static int gcdThing(int a, int b) { 
        if (b==0) return a;
        return GCD(b,a%b);
    }

    public static Frac add(Frac a, Frac b){ 
        a.num *= b.denom;
        b.num *= a.denom;
        int denom = a.denom * b.denom;
        int top = a.num + b.num;
        int f1 = gcdThing(top, denom);
        Frac f = new Frac(top/f1,denom/f1);
        return (f);
    }

    public Frac add(Frac f){
        return (add(this, f));
    }

    public static sub(Frac a, Frac b){// need common denom
        a.num *= b.denom;
        b.num *= a.denom;
        int denom = a.denom*b.denom;
        int top = a.num-b.num;
        int f1 = gcdThing(top, denom);
        Frac f = new Frac(top/f1,denom/f1);
        return (f); 
        return (Frac());
    }

    public static mul(Frac a, Frac b){
        return (Frac(a.num*b.num,a.denom*b.denom));
    }

    public static div(Frac a, Frac b){ //write exeption for division by 0
        return (Frac(a.num*b.denom,a.denom*b.num));
    }
    @Override 
    public String toString() {
        return num + "/" + denom;
    }

    @Override
    public boolean equals(Frac f) {
        if (num == f.num && denom == f.denom){//if hashcode1 == hashcode2 retun true
            return true;
        } else {
        return false;
    }
    }

    @Override
    public int hashcode() {
        return 
        //object.hashcode();
    }

    
}