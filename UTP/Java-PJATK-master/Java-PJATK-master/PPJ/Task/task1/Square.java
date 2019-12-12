package task1;
public class Square{
    private double edge;

    public Square(double edge){
        this.edge = edge;
    }
    public double getEdge(){
        return edge;
    }

    public void show(){
        System.out.println(edge * edge);
        System.out.println(edge * edge * edge);
    }

    public Cylinder showCylinder(){
        Cylinder c1 = new Cylinder(this);
        return c1;
    }

}