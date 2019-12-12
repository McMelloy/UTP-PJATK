import java.lang.Math;
public class Square implements Comparable<Square>, Figure {
    private static int counter = 1; 
    private int length;
    private int number;

    public Square(int l) throws TooBigSquareException{
        if(l > Max){
            throw new TooBigSquareException("Maximum length is "+ Max);
        }else{
            length = l;
            number = counter;
            counter++;
        }
        
    }

    public int getArea(){
        return length*length;
    }

    public int getPerimeter(){
        return length*4;
    }


    @Override
    public int compareTo(Square s) {
        int diff = getArea() - s.getArea();
        if (diff < 0) {
            return -1;
        }else if (diff > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override 
    public String toString() {
        return "("+ number + "): "+ getArea();
    }
}