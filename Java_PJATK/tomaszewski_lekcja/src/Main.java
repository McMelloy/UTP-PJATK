import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyColor mc = new MyColor(10, 50, 100);
        System.out.println(mc);

        ArrayList<MyColor> al = new ArrayList<>();
        al.add(mc);
        al.add(new MyColor(60, 50, 120));
        System.out.println(al.get(1));

        ArrayBlockingQueue<MyColor> abq = new ArrayBlockingQueue<>(10);
        abq.add(mc);
        abq.add(new MyColor(70,60,65));

        try{
            MyColor c = abq.take();
            System.out.println(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HashMap<String, MyColor> hm = new HashMap<>();
        hm.put("kolorX", mc);
        hm.put("kolorY", new MyColor(255,0,10));
        System.out.println();

        for(String i : hm.keySet())
            System.out.println(hm.get(i));

        myArray ma = new myArray();
        ma.add(10);
        ma.add(20);
        ma.add(50);

        Iterator<Integer> iterator = ma.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Integer i : ma)
            ;

    }
}

class MyColor{
    int r, g, b;
    public MyColor(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString(){
        return (r + " "+g +" "+b);
    }
}
