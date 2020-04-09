public class Add {
    private String first;
    private String second;
    private int result;

    Add(String first, String second){
        this.first = first;
        this.second = second;
        this.result = Integer.parseInt(first) + Integer.parseInt(second);
    }

    public int getResult(){
        return result;
    }
}
