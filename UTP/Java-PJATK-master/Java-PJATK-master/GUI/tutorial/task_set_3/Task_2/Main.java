import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        try{
            Square [] sq = {
            new Square(2), new Square(1), new Square(5) , new Square(6), new Square(3)
            };
            System.out.println("Unsorted: " + Arrays.toString(sq));
            Arrays.sort(sq);
            for (Square s: sq) {
                System.out.println(s);
            }
        }catch(TooBigSquareException e){
            System.out.println(e);
        }

        
        
    }
}