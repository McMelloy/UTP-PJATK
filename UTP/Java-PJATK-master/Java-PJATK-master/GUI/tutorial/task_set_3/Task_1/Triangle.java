import java.lang.Math;
public class Triangle extends Figure {
    private int edge;
    public Triangle(int a){
        edge = a;
    } 
    public double findPer(){
        perimeter = 3*edge;
        return perimeter;
    }
   
    public double findAr() {
       area = edge*edge*Math.sqrt(3)/4; 
       return area;
    }
    @Override
    public String toString() {
        return "Triangle: edge " + edge + " perimeter: " + findPer() + " area: " + findAr()+"\n";  
    }
}