public class Main{
    public static void main(String[] args) {
        B b = new B(){
            @Override 
            public void d(){
                System.out.println(c);
            }    

            public void t() {
                System.out.println("t");
            }

            public void e() {
                
            }
        };

        b.d();
    }
}