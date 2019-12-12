package prd;
public class Storage {
    private Box[] boxes;

    public Storage(Box[] boxes){
        this.boxes = boxes;
    }

    public int totQuant(String n){
        int tot = 0;
        for (Box var : boxes) {
            for(Product var1 : var.getProd()){
                if(n.equals(var1.getName())){
                    tot += var1.getQuant();
                }
            }
        }
        return tot;
    }
} 