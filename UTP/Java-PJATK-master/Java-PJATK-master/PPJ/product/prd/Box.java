package prd;
public class Box{
    private String id;
    private Product[] prods;

    public Box(String id, Product[] prods) {
        this.id = id;
        this.prods = prods;
    }

    public Product[] getProd(){
        return prods;
    }
}