import java.util.Iterator;
import java.util.NoSuchElementException;
class Casino implements Iterable<Integer> {
    private int curr;
    public Casino(){
        curr = (int)(Math.random()*2);
    }
    public Iterator<Integer> iterator(){
        return new Cas(curr);
    }
    
    private static class Cas implements Iterator<Integer>{
        private int curr;
        private int c_zero = -1;
        private int c_one = -1;

        public Cas(int curr){
            this.curr = curr;
        }

        @Override
        public boolean hasNext(){
            if(curr == 0){
                c_zero++;
                c_one = 0;
            }else {
                c_one++;
                c_zero = 0;
            }

            if((c_one == 3) || (c_zero ==3)){
                return false;
            }else return true;
        }

        @Override 
        public Integer next() {
            return curr = (int)(Math.random()*2);
        }
    }
}
public class Task_3 {
    public static void main(String[] args) {
        for (int turn = 0; turn < 10; ++turn) {
            for (Integer i : new Casino())
                System.out.print(i + " ");
                System.out.println();
        }
    }
}