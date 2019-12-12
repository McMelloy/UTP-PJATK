public interface Internet {
    public abstract boolean has_internet();
    default void internet(){
        System.out.println("Has internet");
    };
}