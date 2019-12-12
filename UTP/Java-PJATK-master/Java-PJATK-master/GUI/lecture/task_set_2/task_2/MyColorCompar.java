import java.util.Comparator;
import java.awt.Color;
public class MyColorCompar implements Comparator<MyColor>{
    ColComponent c;
    public MyColorCompar(ColComponent c){
        this.c  = c;
    }
    
    @Override
    public int compare(MyColor o1, MyColor o2) {
        switch (c) {
            case RED:
                if (o1.equals(o2)){
                    return 0;
                }else if (o1.red > o2.red){
                    return 1;
                } else {
                    return -1;
                }
            case BLUE:
                if (o1.equals(o2)){
                    return 0;
                }else if (o1.blue > o2.blue){
                    return 1;
                } else {
                    return -1;
                }
            case GREEN:
                if (o1.equals(o2)){
                    return 0;
                }else if (o1.green > o2.green){
                    return 1;
                } else {
                    return -1;
                }
            default:
                break;
        }
        return 0;
    }
}
