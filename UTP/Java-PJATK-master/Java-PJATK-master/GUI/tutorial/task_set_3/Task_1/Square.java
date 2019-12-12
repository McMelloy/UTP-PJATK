public class Square extends Figure {
    private int edge;
    public Square(int a){
        edge = a;
    }
    public double findPer(){
        perimeter = edge*4;
        return perimeter;
    }
   
    public double findAr() {
       area = edge*edge; 
       return area;
    }

    @Override
    public String toString() {
        return "Square: edge " + edge + " perimeter: " + findPer() + " area: " + findAr()+"\n";  
    }
}