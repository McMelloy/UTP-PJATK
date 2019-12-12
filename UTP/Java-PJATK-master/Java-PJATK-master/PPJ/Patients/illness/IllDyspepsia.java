package illness;
public class IllDyspepsia extends Patient {
    public IllDyspepsia(String name){
        this(name, "coal", "dispepsia");
    }

    public IllDyspepsia(String name, String b, String c){
        super(name, b, c);
    }
}