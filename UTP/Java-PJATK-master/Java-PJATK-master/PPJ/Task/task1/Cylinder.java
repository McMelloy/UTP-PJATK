package task1;
public class Cylinder{
    private double radius;
    private double height; 

    public Cylinder(double a, double b){
       radius = a;
       height = b;
    }

    public Cylinder(Square a){
        Cylinder r = new Cylinder(a.getEdge()/2 , a.getEdge());
    }

    public void show(){
        System.out.println(Math.PI * radius * radius);
        System.out.println(Math.PI * radius * radius * height);
    }
}