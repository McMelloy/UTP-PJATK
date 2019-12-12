package squarepkg;
import circlepkg.Circle;
public class Square{
    private double side;
    private Square h;
    //constructor
    public Square(double side){
       this.side = side;
    }
    //constructor object of square 
    public Square(Circle l){
        h = new Square(Math.sqrt(l.getArea()));
    }
    public Square getCircle(){
        return h;
    }
    public double getSide(){
        return side;
    }
    public double getArea(){
        return side * side;
    }
    public double getDiagonal(){
        return Math.sqrt(2*(side*side));
    }
    public double getPerimeter(){
        return(side*4);
    }
    public Object getInscribedCircle(){
        Circle c = new Circle(side/2);
        return c;
    }
    public Object getCircumscribedCircle(){
        Circle v = new Circle((getDiagonal()/2));
        return v;
    }
    @Override
    public String toString(){
        return "A square of side " + side;
    }
}


