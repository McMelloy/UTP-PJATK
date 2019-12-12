import java.util.Arrays;

public class SimpleArrayList{
    private final static int INITIAL_CAPASITY = 5; 
    private int size = 0;
    private int cap = INITIAL_CAPASITY;
    private int [] arr = new int[cap];
    
    public static void main(String[] args) {
       SimpleArrayList a =
            new SimpleArrayList()
                .append(new int[]{1,3}).insert(1,2)
                .append(6).insert(3,new int[]{4,5});
        SimpleArrayList b = new SimpleArrayList(a);
        for (int i = 0; i < a.size(); ++i)
            a.set(i,a.get(i)+6);
        b.append(a).append(13).trim();
        System.out.println("a -> " + a);
        System.out.println("b -> " + b);
    }

    public SimpleArrayList(){
        size = 0;
        cap = INITIAL_CAPASITY;
    }

    public SimpleArrayList(int a){
        arr[0] = a;
        size = 1;
    }

    public SimpleArrayList(int [] crr){
        arr = crr;
        size = arr.length;
        cap = crr.length;
    }

    public SimpleArrayList(SimpleArrayList arrlist){
        arr = arrlist.arr.clone();
        size = arrlist.size;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
        cap = INITIAL_CAPASITY;
        arr = new int [cap];
    }

    public void trim(){
        cap = size;
    }

    public SimpleArrayList insert (int ind, int [] other) throws IndexOutOfBoundsException{
        if (ind > size || ind < 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(cap < (size + other.length)){ 
            int [] tmp = arr;
            arr = new int[(size + other.length)*2];
            for(int i = 0; i < tmp.length; i++){
                arr[i]=tmp[i];
            }
            cap=(size + other.length)*2;
            

        } 

        for(int i = ind; i < other.length + ind; i++){
            arr[i+other.length] = arr[i];
            arr[i] = other[i-ind];
        }             

        size+=other.length;
        return this;
    }

    public SimpleArrayList insert(int ind, int e){
        insert(ind, new int[]{e});
        return this;
    }

    public SimpleArrayList append(int e){
        insert(size, e);
        return this;     
    }

    public SimpleArrayList append(int[] a) {
        insert(size, a);
        return this;
    }

    public SimpleArrayList append(SimpleArrayList a) {
        int [] tmp = new int [a.size];
        for (int i = 0; i < a.size; i++) {
            tmp[i] = a.arr[i];
        }
        insert(size,tmp);
        return this;
    }

    public int get (int ind) throws IndexOutOfBoundsException{
        if (ind >(size-1)){
            throw new IndexOutOfBoundsException();
        }
        return arr[ind];
    }

    public SimpleArrayList set(int ind, int val) throws IndexOutOfBoundsException{
        if (ind >(size-1)){
            throw new IndexOutOfBoundsException();
        }
        arr[ind] = val;
        return this;
    }
    
    @Override
    public String toString(){
        return "Cap="+cap+", size="+size+": "+Arrays.toString(arr);
    }
}