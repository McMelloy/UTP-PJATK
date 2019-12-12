import java.util.Random;

public class Request extends Message {
    private final int LOW = 0;
    private final int HIGH = 100;
    private Random rand = new Random();
    private int value1;
    private int value2;
    private Priority pr;
    private static int count = 0;
    private final int id;

    private static synchronized int getID(){
        count++;
        return count;
    }

    public Request(Requester r) {
        super(r);
        id = getID();
        pr = Priority.genValue();
        value1 = genValue();
        value2 = genValue();
        System.out.println(pr +" "+value1+" " + value2 + " id " + id);
    }


    public int genValue(){
        return rand.nextInt(HIGH - LOW) + LOW;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getId() {
        return id;
    }

    public Priority getPr() {
        return pr;
    }

}
