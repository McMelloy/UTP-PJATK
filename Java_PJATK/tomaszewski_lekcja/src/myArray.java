import java.util.Iterator;

public class myArray implements Iterable<Integer>{
    int tab[];
    int size;

    public myArray(){
        tab = new int[5];
        size = 0;
    }

    public void add(int val){
        if(size >= tab.length){
            int[] tmp = new int[tab.length*2];
            for(int i=0;i<tab.length;i++){
                tmp[i]= tab[i];
            }
            tab = tmp;
        }
        tab[size++] = val;
    }

    int getSize(){
        return size;
    }

    int get(int index){
        return tab[index];
    }

    @Override
    public Iterator<Integer> iterator(){
        return null;
    }
}
