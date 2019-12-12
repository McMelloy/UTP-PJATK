public class Computer {
    int alt;
    int measure;


    public Computer(int step){
        alt = 0;
        this.step = step;
    }

    public int measure() {
        alt+= step;
        return alt;
    }
}