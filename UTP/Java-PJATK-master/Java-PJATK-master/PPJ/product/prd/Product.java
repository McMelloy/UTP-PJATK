package prd;
public class Product {
    private String name;
    private int quant;

    public Product(String name, int quant) {
        this.name = name;
        this.quant = quant;
    } 

    public String getName(){
        return name;
    }

    public int getQuant(){
        return quant;
    }
}