

public class Main extends AClass {

    Main(String s) {
        super(1 + Double.parseDouble(s));
    }

    int met(int b) {
        return super.met(b);
    }

    public static void main(String[] args) {
        boolean cond = true;
        int a = 14;
        while (cond) {
            System.out.print(a + " ");
            a = a >> 1;
            cond = ((a & 0b1) ^ 0b0) == 1;
        }

        System.out.println("+");

        int[] arr = {1, 2, 3};
        try {
            System.out.print("START ");
            System.out.print(arr[3] + " ");
        } catch (NullPointerException en) {
            System.out.print("NPE ");
        } catch (Exception ex) {
            System.out.print("EXC ");
        } finally {
            System.out.print("FIN ");
        }
        System.out.println("END ");

        String s1 = "PPJ123TEST",
                s2 = s1.substring(3, 5);
        System.out.println(s1.length() + " " + Double.parseDouble(s2) + " " + s1.substring(5, 6));

        AClass b = new AClass(2);
        AClass c = new Main("1");
        Main d = new Main("-2");
        System.out.println(b.met(13) + " " + c.met(2) + " " + d.met(-2));
    }
}

class AClass {
    double val;

    AClass(double v) {
        val = v;
    }

    int met(int a) {
        return (int)(a / val);
    }
}
