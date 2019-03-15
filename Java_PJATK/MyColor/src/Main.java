import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.Color;

class MyColor extends Color implements Comparable<MyColor>{
    MyColor(int r, int g, int b){
        super(r,g,b);
    }
    @Override
    public int compareTo(MyColor other){
        return (this.getRed()+this.getGreen()+this.getBlue())-
                (other.getRed()+other.getGreen()+other.getBlue());
    }
    @Override
    public String toString(){
        return "("+this.getRed()+", "+this.getGreen()+", "+this.getBlue()+")";
    }
}

class MyColorCompar implements Comparator<MyColor>{
    String color;
    MyColorCompar(String c){
        color = c;
    }
    @Override
    public int compare(MyColor one, MyColor two){
        if (color.equals("Red"))
            return one.getRed()-two.getRed();
        else if(color.equals("Green"))
            return one.getGreen()-two.getGreen();
        else if(color.equals("Blue"))
            return one.getBlue()-two.getBlue();
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        List<MyColor> list = Arrays.asList( new MyColor( 1, 2, 3), new MyColor(255, 0, 0), new MyColor( 55, 55,100), new MyColor( 10,255, 10) );
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort( list, new MyColorCompar("Red"));
        System.out.println(list);
        Collections.sort( list, new MyColorCompar("Green"));
        System.out.println(list);
        Collections.sort( list, new MyColorCompar("Blue"));
        System.out.println(list);
    }
}