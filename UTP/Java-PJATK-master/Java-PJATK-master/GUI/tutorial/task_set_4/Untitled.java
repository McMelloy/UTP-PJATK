/*

 In main method:
	- Using anonymous inner class create an object if B type.
    - Call all available methods for that object
*/
class Untitled{
    public static void main(String [] args){
        B bannana = new B(){
            void d(){
                System.out.println("guvno");
            }
        };
        bannana.d();
    }
}
interface C{
    void e(B b);
}
interface D{
    void f(C c);
}
abstract class B{
    double c;
    B(){
        c = 1.5;
    }
    abstract void d();
}
class A extends B{
    String a;
    int b;
    A(){
        a = "NONE";
        b = 0;
    }
    A(String a, int b){
        this.a = a;
        this.b = b;
    }
    void d(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}