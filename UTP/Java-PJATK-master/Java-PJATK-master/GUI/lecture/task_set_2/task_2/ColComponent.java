import java.util.Comparator;
public enum ColComponent implements Comparator<MyColor>{RED{
    @Override
    public int compare(MyColor o1, MyColor o2) {
        System.out.println("working");
        if (o1.equals(o2)){
            return 0;
        }else if (o1.blue > o2.blue){
            return 1;
        } else {
            return -1;
        }
    }
}, 
GREEN{@Override
    public int compare(MyColor o1, MyColor o2) {
        System.out.println("working");
        if (o1.equals(o2)){
            return 0;
        }else if (o1.blue > o2.blue){
            return 1;
        } else {
            return -1;
        }
    }
}, 
BLUE{@Override
        public int compare(MyColor o1, MyColor o2) {
            System.out.println("working");
            if (o1.equals(o2)){
                return 0;
            }else if (o1.blue > o2.blue){
                return 1;
            } else {
                return -1;
            }
        }
    }
};