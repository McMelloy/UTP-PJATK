import java.util.Iterator;
import java.util.NoSuchElementException;

class Hailstone implements Iterable<Integer>{
    private int ini;
    public Hailstone(int ini){
        this.ini = ini;
    }

    public Iterator<Integer> iterator() {
        return new H(ini);
    }

    private static class H implements Iterator<Integer> {
        private int ini;
        public H(int ini){
            this.ini = ini;
        }

        @Override
        public boolean hasNext(){
            if(ini%2 == 0) {
                ini = ini/2;
                if(ini == 1) {
                    return false;
                }else return true;
            }else {
                ini = 3*ini+1;
                if(ini == 1) {
                    return false;
                }else return true;
            }
       
        }
    
        @Override 
        public Integer next(){
            return ini;
        }
    }

   
}

public class Task_2 {
    public static void main(String... args) {
        int ini = 10, count = 1, maxel = 0;
        Hailstone hailstone = new Hailstone(ini);
        for (int h : hailstone) {
            if (h > maxel) {
            maxel = h;}
                
            ++count;  
            System.out.println("count : " + count + " h: " + h);
        }
        System.out.println(ini + " " + count + " " + maxel);
    }
}

