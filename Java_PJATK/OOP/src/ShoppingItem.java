
public class ShoppingItem {

    public static void main(String[] args) {
        AlwaysPositive tupa = new AlwaysPositive(1);
        tupa.print();
        tupa.changeNumber(69);
        tupa.print();
    }
}

class AlwaysPositive {
    private int number;

    public AlwaysPositive(int number) {
        if (number < 0)
            this.number = -number;
        else
            this.number = number;

    }

    public void changeNumber(int x){
        this.number=x;
    }

    public void print(){
        System.out.println(this.number);
    }

}