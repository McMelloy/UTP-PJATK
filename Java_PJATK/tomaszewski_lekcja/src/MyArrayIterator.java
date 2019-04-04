import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {
    myArray myArray;
    int currentIndex;

    public MyArrayIterator(myArray ma){
        this.myArray = ma;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < myArray.getSize();
    }

    @Override
    public Integer next() {
        return myArray.get(currentIndex+1);
    }
}
