public class SimpleArrayList {
    private int size = 0;
    private final static int INITIAL_CAPACITY = 5;
    private int cap = INITIAL_CAPACITY;
    private int[] arr = new int[cap];
   
    public SimpleArrayList (int a) {
        size = 1;
        arr[0] =  a;
    }

    public SimpleArrayList(int[] crr) {
        size = crr.length;
        arr = crr;
    }

    public SimpleArrayList(SimpleArrayList a){
        arr = arrlist.arr.clone();
        size = arrlist.size;
    }

    public int getSize() {
        return size;
    }

    public SimpleArrayList clear() {
        size = 0;
        cap = INITIAL_CAPACITY;
        arr = new int[size];
    }

    public void trim(){
        cap = size;
    }
    public SimpleArrayList insert(int ind, int [] other) throws IndexOutOfBoundsException{
        if (ind > size || ind < 0){
            throw new IndexOutOfBoundsException();
        }
        if ((size+other.length)>cap){
            int [] tmp = arr;
            arr = new int [((size +other.length-1)*2)];
            cap = (size+other.length)*2;
            for (int z = 0; z <tmp.length;z++){
                arr[z] = tmp[z];
            }
        }
        for(int i = ind; i < other.length + ind; i++){
            arr[i+other.length] = arr[i];
            arr[i] = other[i-ind];
        }  
        size += other.length;           
        return this;
    }
    public SimpleArrayList insert(int ind, int e){ //the first inserts a single element e at position ind
        insert(ind, new int[]{e});
        return this;
    }
    public SimpleArrayList append(int e){ //the second appends a single element e at the end of the vector;
        insert(size, e);
        return this;
    }
    public SimpleArrayList append(int [] e){ //the third appends to the vector elements from the array passed as an argument;
        for (int o = 0; o < e.length;o++){
            append(e[o]);
        }
        return this;
    }
    public SimpleArrayList append(SimpleArrayList a){ //the fourth appends to the vector elements from another vector passed as an argument.
        int [] tmp = new int [a.size];
        for (int i = 0; i < a.size; i++) {
            tmp[i] = a.arr[i];
        }
        insert(size, tmp);
        return this;
    }
    public int get(int ind)throws IndexOutOfBoundsException{//returns ind-th element of the vector
        if (ind >(size-1)){
            throw new IndexOutOfBoundsException();
        }
        return arr[ind];
    }
    public SimpleArrayList set(int ind, int val)throws IndexOutOfBoundsException{//modifies the element under index ind assigning the value val to it
        if (ind >(size-1)){
            throw new IndexOutOfBoundsException();
        }
        arr[ind] = val;
        return this;
    }
    @Override
    public String toString() { 
        return "Cap="+cap+", size="+size+": "+Arrays.toString(arr);
    }
}



}