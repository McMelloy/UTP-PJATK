public class Rectangle extends Figure {
    private int edge1;
    private int edge2;
    public Rectangle(int a, int b){
        edge1 = a;
        edge2 = b;
    }
    public double findPer(){
        perimeter = 2*(edge1+edge2);
        return perimeter;
    }
   
    public double findAr() {
       area = edge1*edge2; 
       return area;
    }

    @Override
    public String toString() {
        return "Rectangle: edge1 " + edge1 + " edge2 "+edge2 + " perimeter: " + findPer() + " area: " + findAr()+"\n";  
    }
}
