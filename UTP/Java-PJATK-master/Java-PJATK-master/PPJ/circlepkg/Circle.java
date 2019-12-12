package circlepkg;
import squarepkg.*;
public class Circle {
    private double rad;
    public Circle(double rad) {
        this.rad = rad;
    }
    public Circle(Object k){
        Square e = new Square(Math.sqrt(Math.PI*rad*rad));
    }
    public double getRad() {
        return rad;
    }
    public double getArea() {
        return Math.PI*rad*rad;
    }
    public double getPerimeter() {
        return 2*rad*Math.PI;
    }
    public double getInscribedSquare() {
        Square n = new Square(((Math.sqrt(Math.pow((getRad()*2) , 2)/2))));
        double y = n.getSide();
        return y;
    }
    public double getCircumscribedSquare() {
        Square m = new Square((getRad()*2));
        double x = m.getSide();
        return x;
    }

    @Override
    public String toString(){
        return "A circle of radius " + rad;
    }


    public static Square[] getSquares(Circle[] arr){
        Square arrf[] = new Square[arr.length];
        for( int i = 0; i < arr.length; i++){
            Square h = new Square(arr[i]);
            arrf[i] = h.getCircle(); 
        }
        return arrf;

    }
}