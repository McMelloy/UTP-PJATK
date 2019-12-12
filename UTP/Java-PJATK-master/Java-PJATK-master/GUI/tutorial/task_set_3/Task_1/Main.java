import java.util.Arrays;
public class Main{
    public static void main(String[] args) {
        Figure[] arr = {
            new Triangle(2), new Circle(2), new Rectangle(2,4), new Square(2)
        };
       System.out.println(Arrays.toString(arr));
    }
}