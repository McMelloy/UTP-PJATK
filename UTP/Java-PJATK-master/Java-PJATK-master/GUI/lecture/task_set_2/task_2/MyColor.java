public class MyColor extends java.awt.Color implements Comparable<MyColor>{
    int red;
    int green; 
    int blue;
    public MyColor(int red, int green, int blue) {
        super(red, green, blue);
        this.red = red;
        this.blue = blue;
        this.green = green;
        
    }

    @Override
    public int compareTo(MyColor o) {
        int sum = o.red + o.blue + o.green;
        if(sum == red + blue + green){
            return 0;
        }else if(sum < red + blue + green){
            return +1;
        }else return -1;
    }

    @Override
    public String toString() {
        return "(" + red + ", " + green + ", " + blue +")"; 
    }
}