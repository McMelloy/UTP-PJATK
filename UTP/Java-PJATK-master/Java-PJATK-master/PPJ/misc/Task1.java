

import squarepkg.*;
import circlepkg.*;
public class Task1{
    public static void main(String[] args){
        Square sq1 = new Square(10);
        System.out.println(sq1.getSide());
        System.out.println(sq1.getArea());
        System.out.println(sq1.getDiagonal());
        System.out.println(sq1.getPerimeter());
        Circle cir1 = new Circle(4);
        System.out.println((sq1.getInscribedCircle()));
        System.out.println((sq1.getCircumscribedCircle()));
        System.out.println((cir1.getInscribedSquare()));

        System.out.println((cir1.getCircumscribedSquare()));


        Square[] sqs = {new Square(2), new Square(1),
        new Square(3), new Square(2)};
        for (Square s : sqs)
        System.out.print(s + " ");

        System.out.print("\nAreas: ");
        for (Square s : sqs)
        System.out.print(s.getArea() + " ");
        System.out.print("\nPerimeters: ");
        for (Square s : sqs)
        System.out.print(s.getPerimeter() + " ");

        Circle[] crs = {new Circle(2), new Circle(1),
                    new Circle(3), new Circle(2)};
        Square[] squares = Circle.getSquares(crs);
        System.out.println( "\nArea of squares " +
                        "from circles: ");
        for (Square s : squares)
        System.out.printf("%.2f ", s.getArea());
        System.out.println();

    }
}j