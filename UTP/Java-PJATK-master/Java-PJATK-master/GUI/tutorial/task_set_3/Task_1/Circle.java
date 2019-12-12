import java.lang.Math;
public class Circle extends Figure{
    private int rad;
    public Circle(int a){
        rad=a;
    }
    public double findPer(){
        perimeter= 2*Math.PI*rad;
        return perimeter;
    }

    public double findAr() {
        area = Math.PI*rad*rad; 
        return area;
     }

    @Override
    public String toString() {
        return "Circle: rad " + rad + " perimeter: " + findPer() + " area: " + findAr()+"\n";  
    }
}